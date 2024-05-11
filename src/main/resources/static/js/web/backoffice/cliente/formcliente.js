$(document).on("click", "#btnagregar", function(){
    $("#hddclicod").val("0");
    $("#txtnomcliente").val("");
    $("#txtdireccion").val("");
    $("#txtemail").val("");
    $("#txttelefono").val("");
    $("#switchcliente").hide();
    $("#cbdactivo").prop("checked", false);
    $("#modalcliente").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#hddclicod").val($(this).attr("data-clicod"));
    $("#txtnomcliente").val($(this).attr("data-clinom"));
    $("#txtdireccion").val($(this).attr("data-clidir"));
    $("#txtemail").val($(this).attr("data-cliema"));
    $("#txttelefono").val($(this).attr("data-clitel"));
    $("#switchcliente").show();
    if($(this).attr("data-cliact") === "true"){
        $("#cbdactivo").prop("checked", true);
    }else
        $("#cbdactivo").prop("checked", false);
    $("#modalcliente").modal("show");
})


$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/cliente/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            clienteid: $("#hddclicod").val(),
            nombre: $("#txtnomcliente").val(),
            direccion: $("#txtdireccion").val(),
            email: $("#txtemail").val(),
            telefono: $("#txttelefono").val(),
            activo: $("#cbdactivo").prop("checked")
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarClientes()
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalcliente").modal("hide");
});

function listarClientes(){
    $.ajax({
        type: "GET",
        url: "/cliente/lista",
        dataType: "json",
        success: function(resultado){
            $("#tblcliente > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblcliente > tbody").append(`<tr>`+
                `<td>${value.clienteid}</td>`+
                `<td>${value.nombre}</td>`+
                `<td>${value.direccion}</td>`+
                `<td>${value.email}</td>`+
                `<td>${value.telefono}</td>`+
                `<td>${value.activo}</td>`+
                `<td><button type='button' class='btn btn-success btnactualizar' `+
                    `data-clicod"${value.clienteid}" `+
                    `data-clinom="${value.nombre}" `+
                    `data-clidir="${value.direccion}" `+
                    `data-cliema="${value.email}" `+
                    `data-clitel="${value.telefono}" `+
                    `data-cliact="${value.activo}">Actualizar`+
                `</button></td>`+
                `</tr>`);
            });
        }
    });
}
