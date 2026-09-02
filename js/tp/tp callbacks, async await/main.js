//Actividad 1
// Base de datos simulada (nuestros usuarios)
const users = [
  { id: 1, name: "Ana" },
  { id: 2, name: "Luis" },
  { id: 3, name: "María" },
];

const getUserById = (id, callback) => {
  // Simulamos una operación asincrónica con setTimeout
  setTimeout(() => {
    const user = users.find((user) => user.id === id);
    if (user) {
      callback(null, user); // Llamamos al callback con el usuario encontrado
    } else {
      callback("Usuario no encontrado", null); // Llamamos al callback con un error
    }
  }, 1500);
};

getUserById(2, (error, user) => {
  if (error) {
    console.error("Error:", error);
  } else {
    console.log("Usuario encontrado:", user);
  }
});

//Actividad 2
const getUserByIdPromise = (id) => {
  return new Promise((resolve, reject) => {
    const user = users.find((user) => user.id === id);
    if (user) {
      resolve(user);
    } else {
      reject("Usuario no encontrado");
    }
  });
};

getUserByIdPromise(3)
  .then(user => {
    console.log("Usuario encontrado:", user);
  })
  .catch(error => {
    console.error("Error:", error);
  });

//Actividad 3

const fetchUser = async (id) => {
  try {
    const user = await getUserByIdPromise(id);
    console.log("Usuario encontrado:", user);
  } catch (error) {
    console.error("Error:", error);
  }
}

fetchUser(1);