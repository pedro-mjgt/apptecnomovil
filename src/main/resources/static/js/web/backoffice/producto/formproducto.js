$(document).on("click", "#btnagregar", function(){
    $("#hddprodcod").val("0");
    $("#txtnomproducto").val("");
    $("#cbocategoria").empty();
    $("#cbomarca").empty();
    listarCboCategoriaMarca(0, 0);
    $("#txtpreproducto").val("");
    $("#txtstoproducto").val("");
    $("#switchproducto").hide();
    $("#cbdactivo").prop("checked", false);
    $("#modalproducto").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#hddprodcod").val($(this).attr("data-prodcod"));
    $("#txtnomproducto").val($(this).attr("data-prodnom"));
    $("#cbocategoria").empty();
    $("#cbomarca").empty();
    listarCboCategoriaMarca($(this).attr("data-prodcat"), $(this).attr("data-prodmar"));
    $("#txtpreproducto").val($(this).attr("data-prodpre"));
    $("#txtstoproducto").val($(this).attr("data-prodsto"));
    $("#switchproducto").show();
    if($(this).attr("data-prodact") === "true"){
        $("#cbdactivo").prop("checked", true);
    }else
        $("#cbdactivo").prop("checked", false);
    $("#modalproducto").modal("show");
})

function listarCboCategoriaMarca(categoriaid, marcaid){
    $.ajax({
        type: "GET",
        url: "/categoria/get",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbocategoria").append(
                    `<option value="${value.categoriaid}">${value.nombre}</option>`
                )
            });
            if(categoriaid > 0){
                $("#cbocategoria").val(categoriaid);
            }
            $.ajax({
                    type: "GET",
                    url: "/marca/get",
                    dataType: "json",
                    success: function(resultado){
                        $.each(resultado, function(index, value){
                            $("#cbomarca").append(
                                `<option value="${value.marcaid}">${value.nombre}</option>`
                            )
                        });
                        if(marcaid > 0){
                            $("#cbomarca").val(marcaid);
                        }
                    }
                })
        }
    })
}

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/producto/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            productoid: $("#hddprodcod").val(),
            nombre: $("#txtnomproducto").val(),
            categoriaid: $("#cbocategoria").val(),
            marcaid: $("#cbomarca").val(),
            precio: $("#txtpreproducto").val(),
            stock: $("#txtstoproducto").val(),
            activo: $("#cbdactivo").prop("checked")
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarProductos()
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalproducto").modal("hide");
});

function listarProductos(){
    $.ajax({
        type: "GET",
        url: "/producto/lista",
        dataType: "json",
        success: function(resultado){
            $("#tblproducto > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblproducto > tbody").append(`<tr>`+
                `<td>${value.productoid}</td>`+
                `<td>${value.nombre}</td>`+
                `<td>${value.categoria.nombre}</td>`+
                `<td>${value.marca.nombre}</td>`+
                `<td>${value.precio}</td>`+
                `<td>${value.stock}</td>`+
                `<td>${value.activo}</td>`+
                `<td><button type='button' class='btn btn-success btnactualizar' `+
                    `data-prodcod="${value.productoid}" `+
                    `data-prodnom="${value.nombre}" `+
                    `data-prodcat="${value.categoria.categoriaid}" `+
                    `data-prodmar="${value.marca.marcaid}" `+
                    `data-prodpre="${value.precio}" `+
                    `data-prodsto="${value.stock}" `+
                    `data-prodact="${value.activo}">Actualizar`+
                `</button></td>`+
                `</tr>`);
            });
        }
    });
}
