//Variables Globales
//api de base de datos, gestionado en el controller

const API_DRAGONBALL = 'http://localhost:8080/api/characters';
const API_NARUTO = 'http://localhost:8081/api/peleadores'; 

//elementos del html
const fighter1Select = document.getElementById('fighter1');
const fighter2Select = document.getElementById('fighter2');
const fighter1Image = document.getElementById('fighter1Image');
const fighter2Image = document.getElementById('fighter2Image');
const fightButton = document.getElementById('fightButton');
const resultDiv = document.getElementById('result');
//guardamos los datos obtenidos
let characters = [];
let ninjas = [];
//Traer a los luchadores
async function fetchData() {
//para una api
try {
const responseDB = await fetch(API_DRAGONBALL);
characters = await responseDB.json();
console.log(characters);
} catch (error) {
console.error('Error al cargar los personajes:', error);
}
//repetido para otra api
try {
const responseNaruto = await fetch(API_NARUTO);
ninjas = await responseNaruto.json();
} catch (error) {
console.error('Error al cargar los personajes:', error);
}
loadFighters();
}
//Llenar las listas
//por cada peleador creamos un option en el selector
function loadFighters() {
[...characters, ...ninjas].forEach(fighter => {
const armas = fighter.armas || fighter.listaarmas || [];
const option1 = document.createElement('option');
option1.value = JSON.stringify(fighter);
option1.text = `${fighter.nombre} (${armas[0]?.nombre || fighter.aldea || ''})`;
fighter1Select.appendChild(option1);

const option2 = document.createElement('option');
option2.value = JSON.stringify(fighter);
option2.text = `${fighter.nombre} (${fighter.raza || fighter.aldea || ''})`;
fighter2Select.appendChild(option2);
});
updateFighterDisplay(fighter1Select, fighter1Image, 'fighter1Weapon');
updateFighterDisplay(fighter2Select, fighter2Image, 'fighter2Weapon');
}

function updateFighterDisplay(selectEl, imgEl, weaponElId) {
const selected = JSON.parse(selectEl.value);
imgEl.src = selected.url || selected.url_imagen || 'placeholder.png';

const armas = selected.armas || selected.listaarmas || [];
const weaponEl = document.getElementById(weaponElId);
if (armas.length > 0) {
const nombresArmas = armas.map(a => a.nombre).join(', ');
weaponEl.textContent = `⚔️ Arma: ${nombresArmas}`;
} else {
weaponEl.textContent = '⚔️ Sin arma';
}
}

//Reaccionar a los cambios
// Actualizar la imagen al seleccionar un personaje y arma
fighter1Select.addEventListener('change', () => {
updateFighterDisplay(fighter1Select, fighter1Image, 'fighter1Weapon');
});
fighter2Select.addEventListener('change', () => {
updateFighterDisplay(fighter2Select, fighter2Image, 'fighter2Weapon');
});


//La Lógica de Batalla
fightButton.addEventListener('click', () => {
const fighter1 = JSON.parse(fighter1Select.value);
const fighter2 = JSON.parse(fighter2Select.value);
if (!fighter1 || !fighter2) {
alert('Seleccioná ambos luchadores.');
return;
}
// Simular "nivelDePoder"
const power1 = fighter1.nivelDePoder || (Math.floor(Math.random() * 1000) + 500);
const power2 = fighter2.nivelDePoder || (Math.floor(Math.random() * 1000) +
500);
let winner;
if (power1 > power2) {
winner = fighter1.nombre;
} else if (power2 > power1) {
winner = fighter2.nombre;
} else {
winner = "¡Empate!";
}
resultDiv.textContent = `🏆 El ganador es: ${winner}! 🥊`;
resultDiv.classList.remove('hidden');
});
fetchData();