//INVERTIR
let numeros = [1, 2, 3, 4];
let invertido = [];

for (let i = numeros.length - 1; i >= 0; i--) {
    invertido.push(numeros[i]);
}

console.log(invertido); // [4, 3, 2, 1]

// palindromo
let palabra = "reconocer";
let invertida = palabra.split("").reverse().join("");

if (palabra.toLowerCase() === invertida.toLowerCase()) {
    console.log(true);
} else {
    console.log(false);
}
// Contar vocales
let texto = "Javascript ES Genial";
let vocales = "aeiouAEIOU";
let contador = 0;

for (let letra of texto) {
    if (vocales.includes(letra)) {
        contador++;
    }
}

console.log("Cantidad de vocales:", contador);

// Sacar el último elemento y agregarlo al inicio
let array = [10, 20, 30, 40];

// Sacar el último elemento
let ultimo = array.pop();

// Agregarlo al inicio
array.unshift(ultimo);

console.log(array); // [40, 10, 20, 30]


// Ordenar sin sort
let arrayNumeros = [5, 2, 9, 1];

for (let i = 0; i < arrayNumeros.length; i++) {
    for (let j = i + 1; j < arrayNumeros.length; j++) {

        if (arrayNumeros[i] > arrayNumeros[j]) {
            let aux = arrayNumeros[i];
            arrayNumeros[i] = arrayNumeros[j];
            arrayNumeros[j] = aux;
        }

    }
}

console.log(arrayNumeros); // [1, 2, 5, 9]

//Reemplazo de palabras
let frase = "Me gusta programar en Java";
let nuevaFrase = frase.replaceAll("Java", "JavaScript");

console.log(nuevaFrase);

//Numeros unicos sin set
let arrayNum = [1, 2, 2, 3, 4, 4, 5];
let unicos = [];

for (let numero of arrayNum) {

    if (!unicos.includes(numero)) {
        unicos.push(numero);
    }

}

console.log(unicos); // [1, 2, 3, 4, 5]

//interseccion
let array1 = [1, 2, 3, 4];
let array2 = [3, 4, 5, 6];
let comunes = [];

for (let numero of array1) {

    if (array2.includes(numero)) {
        comunes.push(numero);
    }

}

console.log(comunes); // [3, 4]

//contar palabras
let text = "hola mundo hola javascript";
let palabras = text.split(" ");
let cont = {};

for (let palabra of palabras) {

    if (cont[palabra]) {
        cont[palabra]++;
    } else {
        cont[palabra] = 1;
    }

}

console.log(cont);

//Matriz transpuesta
let matriz = [
    [1, 2, 3],
    [4, 5, 6]
];

let transpuesta = [];

for (let i = 0; i < matriz[0].length; i++) {

    transpuesta[i] = [];

    for (let j = 0; j < matriz.length; j++) {
        transpuesta[i].push(matriz[j][i]);
    }

}

console.log(transpuesta);
