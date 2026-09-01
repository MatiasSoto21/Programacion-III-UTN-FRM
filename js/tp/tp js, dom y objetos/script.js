//Punto1
function cuadrado(num) {
    return num * num;
}

let cubo = function(num) {
    return num * num * num;
}

//La primera es declarativa y se carga por completo en memoria antes de ejecutar codigo.
//La segunda es una expresion de funcion y se carga en memoria cuando se ejecuta el codigo.

//Paso3
let saludar = (nombre, edad = 18) => {
    console.log(`Hola, ${nombre}. Tienes ${edad} años.`);
}

//Punto3
let persona = {
    nombre: "Mati",
    edad: 25,
    presentarse: () =>{
        console.log(`Hola, soy ${this.nombre} y tengo ${this.edad} años.`);
    }
}
//Propiedades: datos del objeto (nombre y edad).
//Métodos: funciones dentro del objeto (presentarse).

//Punto4
const {nombre,edad} = persona;

console.log(nombre);
console.log(edad);
/*
Ventaja:
Permite obtener varias propiedades de un objeto en una sola línea.
*/

//Punto5
const numeros = [1, 2, 3, 4];
const nuevosNumeros = [...numeros, 5, 6, 7];

const sumar = (...valores) => {

    let suma = 0;

    for (let numero of valores) {
        suma += numero;
    }

    return suma;
};

/*
Spread (...) expande elementos.
Rest (...) reúne varios argumentos en un array.
*/

//Punto6
const titulo = document.getElementById("titulo");
const lista = document.getElementById("lista");

// Cambiar texto del título
titulo.textContent = "TP JavaScript Completo";

// Agregar elementos nuevos
const tarea1 = document.createElement("li");
tarea1.textContent = "Practicar funciones";
lista.appendChild(tarea1);

const tarea2 = document.createElement("li");
tarea2.textContent = "Manipular el DOM";
lista.appendChild(tarea2);

// Agregar clase
titulo.classList.add("destacado");

// Se puede usar remove() o toggle()
// titulo.classList.remove("destacado");
// titulo.classList.toggle("destacado");

//Punto7
const inputTarea = document.getElementById("inputTarea");
const btnAgregar = document.getElementById("btnAgregar");

btnAgregar.addEventListener("click", () => {

    const texto = inputTarea.value;

    if (texto !== "") {
        const nuevaTarea = document.createElement("li");
        nuevaTarea.textContent = texto;
        lista.appendChild(nuevaTarea);

        inputTarea.value = "";
    }

});

/*
Evento click: detecta cuando el usuario presiona el botón.
Evento input: se utiliza para capturar lo que escribe el usuario.
*/

//Punto8
const formulario = document.getElementById("formulario");
const nombreFormulario = document.getElementById("nombreFormulario");
const mensajeFormulario = document.getElementById("mensajeFormulario");

formulario.addEventListener("submit", (event) => {

    event.preventDefault();

    mensajeFormulario.textContent = `Hola ${nombreFormulario.value}`;

    alert(`Nombre ingresado: ${nombreFormulario.value}`);

    nombreFormulario.value = "";
});

/*
preventDefault() evita que el formulario recargue la página.
*/

//Punto9
const selectLenguajes = document.getElementById("lenguajes");
const resultadoSelect = document.getElementById("resultadoSelect");

// Enter agrega tarea
inputTarea.addEventListener("keydown", (event) => {

    if (event.key === "Enter") {

        event.preventDefault();

        if (inputTarea.value !== "") {
            const nuevaTarea = document.createElement("li");
            nuevaTarea.textContent = inputTarea.value;
            lista.appendChild(nuevaTarea);
            inputTarea.value = "";
        }
    }

});

// Evento change del select
selectLenguajes.addEventListener("change", () => {

    resultadoSelect.textContent =
        `Lenguaje seleccionado: ${selectLenguajes.value}`;

});

/*
input: ocurre mientras el usuario escribe.
change: ocurre cuando cambia la opción del select.
keydown: detecta cada tecla presionada (por ejemplo Enter).
*/