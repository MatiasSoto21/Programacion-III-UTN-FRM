let palabras = [];

// Pedimos 5 palabras al usuario
for (let i = 0; i < 5; i++) {
    let palabra = prompt(`Ingrese la palabra ${i + 1}:`);
    palabras.push(palabra);
}

// Mostramos el array completo
console.log("Array original:");
console.log(palabras);

// Agregar una palabra al inicio
let inicio = prompt("Ingrese una palabra para agregar al inicio:");
palabras.unshift(inicio);

// Agregar una palabra al final
let final = prompt("Ingrese una palabra para agregar al final:");
palabras.push(final);

// Eliminar la segunda palabra
palabras.splice(1, 1);

// Mostrar el array actualizado
console.log("Array actualizado:");
console.log(palabras);

let palabraMasLarga = palabras[0];

// Recorremos el array
for (let palabra of palabras) {

    // Longitud de cada palabra
    console.log(`La palabra "${palabra}" tiene ${palabra.length} caracteres.`);

    // Buscar la palabra más larga
    if (palabra.length > palabraMasLarga.length) {
        palabraMasLarga = palabra;
    }

    // Verificar si contiene la letra "a"
    if (palabra.toLowerCase().includes("a")) {
        console.log(`"${palabra}" contiene la letra "a".`);
    } else {
        console.log(`"${palabra}" NO contiene la letra "a".`);
    }
}

// Mostrar la palabra más larga
console.log(`La palabra más larga es: ${palabraMasLarga}`);



let palabrasInvertidas = [];

// Invertimos cada palabra
for (let palabra of palabras) {
    let invertida = palabra.split("").reverse().join("");
    palabrasInvertidas.push(invertida);
}

// Mostrar en consola
console.log("Palabras invertidas:");
console.log(palabrasInvertidas);

// Mostrar con alert
alert("Palabras invertidas:\n" + palabrasInvertidas.join(", "));

let respuesta = prompt("¿Desea comprobar palíndromos? (sí/no)");

if (respuesta.toLowerCase() === "sí" || respuesta.toLowerCase() === "si") {

    console.log("Palíndromos encontrados:");

    for (let palabra of palabras) {

        let invertida = palabra.split("").reverse().join("");

        if (palabra.toLowerCase() === invertida.toLowerCase()) {
            console.log(`"${palabra}" es un palíndromo.`);
        }
    }

} else {
    console.log("El usuario no quiso comprobar palíndromos.");
}


let contador = 0;

// Contar palabras con más de 4 caracteres
for (let palabra of palabras) {
    if (palabra.length > 4) {
        contador++;
    }
}

console.log(`Cantidad de palabras con más de 4 caracteres: ${contador}`);

// Unir todas las palabras con "-"
let palabrasUnidas = palabras.join("-");

console.log("Palabras unidas:");
console.log(palabrasUnidas);

alert("Palabras unidas:\n" + palabrasUnidas);