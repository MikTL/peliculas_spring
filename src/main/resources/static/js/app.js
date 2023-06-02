function actorSelected(select){
    let index= select.selectedIndex
    let option = select.options[index]
    let id= option.value
    let nombre=option.text
    let urlImagen=option.dataset.url

    option.disabled="disabled"
    select.selectedIndex=0

    agregarActor(id,nombre, urlImagen)
    let ids=$("#ids").val()

    if(ids==""){
        $("#ids").val(id)
    }else{
        $("#ids").val(ids+","+id)
    }
}

function agregarActor(id,nombre,urlImagen){
        let htmlString=`
            <div class="card" col-md-3 m-2 style="width:10rem">
                <img src="${urlImagen}" class="card-img-top"/>
                <div class="card-body">
                    <p class="card-text">${nombre}</p>
                    <button class="btn btn-danger" data-id="${id}" onclick="eliminarActor(this); return false;">ELIMINAR</button>
                </div>
            </div>
        `
        console.log("apunto")
        $("#protagonistas-container").append(htmlString)
}
function eliminarActor(btn){
    let id = btn.dataset.id
    let node = btn.parentElement.parentElement
    let arraysIds = $("#ids").val().split(",").filter(idActor=> idActor!= id)

    $("#ids").val(arraysIds.join(","))
    $("#select-actores option[value='"+id+"']").prop("disabled",false)
    node.remove()
}

function previsualizar(){
    let reader = new FileReader()
    reader.readAsDataURL(document.getElementById("imagen").files[0])

    reader.onload=function(e){
        let vista=document.getElementById("vista_previa")
        vista.classList.remove("d-none")
        vista.style.backgroundImage=`url("${e.target.result}")`

    }
}
