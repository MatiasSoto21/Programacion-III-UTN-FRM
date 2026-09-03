interface SimpsonCharacter {
  id: number;
  age: number;
  birthdate: string;
  gender: string;
  name: string;
  occupation: string;
  portrait_path: string;
  phrases: string[];
  status: string;
}

interface IResponseApi {
  count: number;
  next: string | null;
  prev: string | null;
  pages: number;
  results: SimpsonCharacter[];
}

//constantes
const API_URL: string = "https://thesimpsonsapi.com/api/characters";
const IMAGE_URL: string = "https://cdn.thesimpsonsapi.com/500";
const loadBtn = document.getElementById("loadBtn") as HTMLButtonElement;
const loadingSection = document.getElementById("loading") as HTMLDivElement;
const errorDiv = document.getElementById("error") as HTMLDivElement;
const charactersContainer = document.getElementById(
  "characters",
) as HTMLDivElement;

//funciones
const showLoading = (): void => {
  loadingSection.classList.remove("hidden");
  errorDiv.classList.add("hidden");
};

const hideLoading = (): void => {
  loadingSection.classList.add("hidden");
};

const showError = (message: string): void => {
  errorDiv.textContent = message;
  errorDiv.classList.remove("hidden");
  setTimeout(() => {
    errorDiv.classList.add("hidden");
  }, 5000);
};

//crear tarjeta de personaje
const createCharacterCard = (character: SimpsonCharacter): HTMLElement => {
  const card = document.createElement("div");
  card.classList.add("character-card");

  const image = document.createElement("img");
  image.src = IMAGE_URL + character.portrait_path;
  image.alt = character.name;

  const name = document.createElement("h3");
  name.textContent = character.name;

  const occupation = document.createElement("h4");
  occupation.textContent = `Occupation: ${character.occupation}`;

  const phrase = document.createElement("p");
  if (character.phrases.length > 0) {
    if (character.phrases[0].length > 20) {
      phrase.textContent = `\"${character.phrases[0].slice(0, 22)}...\"`;
    } else {
      phrase.textContent = `\"${character.phrases[0]}\"`;
    }
  } else {
    phrase.textContent = "Sin frase disponible.";
  }

  card.append(image, name, occupation, phrase);

  return card;
};

//renderizar personaje
const renderCharacters = (characters: SimpsonCharacter[]): void => {
  charactersContainer.innerHTML = "";
  characters.forEach((character) => {
    const card = createCharacterCard(character);
    charactersContainer.appendChild(card);
  });
};

// Consumir API
const fetchCharacters = async (): Promise<void> => {
  showLoading();

  try {
    const response = await fetch(API_URL);

    if (!response.ok) {
      throw new Error("Error al obtener personajes de la API.");
    }

    const data: IResponseApi = await response.json();

    if (!data.results || data.results.length === 0) {
      throw new Error("No se encontraron personajes.");
    }

    renderCharacters(data.results);
  } catch (error) {
    console.error(error);

    showError("Ocurrió un error al cargar los personajes.");
  } finally {
    hideLoading();
  }
};

// Event Listener
loadBtn.addEventListener("click", fetchCharacters);
