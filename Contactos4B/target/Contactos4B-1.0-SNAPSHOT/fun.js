function doSearch ( s ) {

    var regExp1 = /field/;
    var regExp2 = /[(,),<,>,[,]]/;
    var str = s.value;
    if ( str == "" ){
        alert("El campo de búsqueda debe contener un valor.");
        s.focus(); }
    else {
        if ( typeof regExp1.source != 'undefined' )
            if ( regExp1.test( str ) || regExp2.test( str ) ){
                var alrt =
                    "Algunos de los caracteres introducidos no están admitidos.";
                s.focus();
                return alert( alrt ); }
        openDbRelativeURL("LibrosBuscar?SearchView&Query=" +
            escape( str ) + "&start=1&count=10"); }

}


function openDbRelativeURL( url, target ) {

    target = (target == null) ? window : target;
    path = location.pathname.split('.nsf')[0] + '.nsf/';
    target.location.href = path + url;
}