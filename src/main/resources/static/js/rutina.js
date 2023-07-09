var contador = 0;

function incrementarContador() {
    contador++;
    document.getElementById("contador").innerHTML = contador;
}

function obtenerContador() {
    return contador;
}

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#blah')
                    .attr('src', e.target.result)
                    .height(200);
        };
        reader.readAsDataURL(input.files[0]);
    }
}