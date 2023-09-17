<script setup>
import Map from '@/components/OlimpiaMapsComponent.vue'
</script>

<template>
  <img class="home__banner" src="../assets/img/prueba_banner.png" alt="Banner masaje">

  <section class="section">
    <article class="card">
      <img class="card__img" src="../assets/img/foto_luci.jpeg" alt="Foto Lucía Pajares">
      <div class="card__info">
        <h3 class="card__info--name">Lucía Pajares Baragaño</h3>
        <p class="card__info--description">Luci es especialista en fisioterapia invasiva ecoguiada y terapia manual; 
          lleva ejerciendo en esta clínica desde 2012 destacando por su autoexigencia y un poco de inconformismo. 
          No lo decimos nosotros, lo dice ella misma: 
          <strong>«Nunca me conformo, la autoexigencia tanto personal como profesional es lo que me caracteriza, pero todos tranquilos, 
            la madurez me ha sentado bien y ahora he encontrado el equilibrio para disfrutar tanto de lo conseguido como de lo que queda por conseguir.»</strong>
          </p>
        <ul>
          <li class="card__info--titles">Diplomatura en Fisioterapia por las Escuelas Universitarias Gimbernat (adscritas a la Universidad Autónoma de Barcelona).</li>
          <li class="card__info--titles">Título de Máster en Osteopatía por la Universidad Pontificia de Salamanca.</li>
          <li class="card__info--titles">Formación continuada en: reeducación en neurología central del adulto, punción seca, ecografía musculoesquelética para fisioterapeutas, electrólisis percutánea intratisular ecoguiada (EPI), neuromodulación percutánea ecoguiada (NMP), Mulligan Concept (cuadrante superior e inferior), Método McKenzie, fibrólisis diacutánea (ganchos) y valoración y tratamiento del sistema fascial.</li>
        </ul>
      </div>
    </article>
    <article class="card">
      <img class="card__img2" src="../assets/img/foto_raquel.jpeg" alt="Foto Lucía Pajares">
      <div class="card__info">
        <h3 class="card__info--name">Raquel Barredo Rodríguez</h3>
        <p class="card__info--description">Raquel es especialista en suelo pélvico, además de terapia manual, fisioestética y fisioterapia deportiva. 
          Colabora como fisio de un equipo de fútbol profesional, y considera el ambiente sano y relajado fundamental para trabajar: 
          <strong>«Me considero una persona implicada y perseverante. Me gusta conseguir lo que me propongo tanto en el ámbito personal como en el profesional. 
            Considero que divertirse y sentirse a gusto trabajando es imprescindible por eso creo que todos juntos formamos un gran equipo«</strong>
          </p>
        <ul>
          <li class="card__info--titles">Graduada en la Universidad de Oviedo.</li>
          <li class="card__info--titles">Postgrado de experto universitario: fisioterapia del suelo pélvico.</li>
          <li class="card__info--titles">Hipopresivos y actividad física en elembarazo.</li>
          <li class="card__info--titles">Formación en: terapia manual, valoración y tratamiento del sistema fascial, ecografía musculo-esquelética, suelo pélvico y maternidad, fisioestética, punción seca.</li>
        </ul>
      </div>
    </article>
  </section>
  <section class="location">
    <h2 class="location__title">¿Dónde estamos?</h2>
    <div class="location__info">
      <Map />
      <article>
        <div>
          <h4>Localización:</h4>
          <a href="https://goo.gl/maps/yFzryhiHUis5T2iW6" target="_blank" class="info__icon">
            <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512">
              <path d="M215.7 499.2C267 435 384 279.4 384 192C384 86 298 0 192 0S0 86 0 192c0 87.4 117 243 168.3 307.2c12.3 15.3 35.1 15.3 47.4 0zM192 128a64 64 0 1 1 0 128 64 64 0 1 1 0-128z"/>
            </svg>
            <p>C.Dolores Ibárruri, 16</p>
          </a>
        </div>
        <div>
          <h4>Horario</h4>
          <ul class="list__planner">
            <li>Lu-Vi de 7:00 a 22:00</li>
            <li>Do de 10:00 a 12:00</li>
          </ul>
        </div>
        <div>
          <h4>Contacta</h4>
          <div class="info__icon">
            <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512">
              <path d="M48 64C21.5 64 0 85.5 0 112c0 15.1 7.1 29.3 19.2 38.4L236.8 313.6c11.4 8.5 27 8.5 38.4 0L492.8 150.4c12.1-9.1 19.2-23.3 19.2-38.4c0-26.5-21.5-48-48-48H48zM0 176V384c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V176L294.4 339.2c-22.8 17.1-54 17.1-76.8 0L0 176z"/>
            </svg>
            <p>hola@olimpiafisioterapia.com</p>
          </div>
          <div class="info__icon">
            <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512">
              <path d="M164.9 24.6c-7.7-18.6-28-28.5-47.4-23.2l-88 24C12.1 30.2 0 46 0 64C0 311.4 200.6 512 448 512c18 0 33.8-12.1 38.6-29.5l24-88c5.3-19.4-4.6-39.7-23.2-47.4l-96-40c-16.3-6.8-35.2-2.1-46.3 11.6L304.7 368C234.3 334.7 177.3 277.7 144 207.3L193.3 167c13.7-11.2 18.4-30 11.6-46.3l-40-96z"/>
            </svg>
            <p>989898989</p>
          </div>
        </div>
        <div>
          <h4>Síguenos</h4>
          <div class="info__icon">
            <a href="https://www.facebook.com/" target="_blank">
              <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512">
                <path d="M504 256C504 119 393 8 256 8S8 119 8 256c0 123.78 90.69 226.38 209.25 245V327.69h-63V256h63v-54.64c0-62.15 37-96.48 93.67-96.48 27.14 0 55.52 4.84 55.52 4.84v61h-31.28c-30.8 0-40.41 19.12-40.41 38.73V256h68.78l-11 71.69h-57.78V501C413.31 482.38 504 379.78 504 256z"/>
              </svg>
            </a>
            <a href="https://www.instagram.com/" target="_blank">
              <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512">
                <path d="M224.1 141c-63.6 0-114.9 51.3-114.9 114.9s51.3 114.9 114.9 114.9S339 319.5 339 255.9 287.7 141 224.1 141zm0 189.6c-41.1 0-74.7-33.5-74.7-74.7s33.5-74.7 74.7-74.7 74.7 33.5 74.7 74.7-33.6 74.7-74.7 74.7zm146.4-194.3c0 14.9-12 26.8-26.8 26.8-14.9 0-26.8-12-26.8-26.8s12-26.8 26.8-26.8 26.8 12 26.8 26.8zm76.1 27.2c-1.7-35.9-9.9-67.7-36.2-93.9-26.2-26.2-58-34.4-93.9-36.2-37-2.1-147.9-2.1-184.9 0-35.8 1.7-67.6 9.9-93.9 36.1s-34.4 58-36.2 93.9c-2.1 37-2.1 147.9 0 184.9 1.7 35.9 9.9 67.7 36.2 93.9s58 34.4 93.9 36.2c37 2.1 147.9 2.1 184.9 0 35.9-1.7 67.7-9.9 93.9-36.2 26.2-26.2 34.4-58 36.2-93.9 2.1-37 2.1-147.8 0-184.8zM398.8 388c-7.8 19.6-22.9 34.7-42.6 42.6-29.5 11.7-99.5 9-132.1 9s-102.7 2.6-132.1-9c-19.6-7.8-34.7-22.9-42.6-42.6-11.7-29.5-9-99.5-9-132.1s-2.6-102.7 9-132.1c7.8-19.6 22.9-34.7 42.6-42.6 29.5-11.7 99.5-9 132.1-9s102.7-2.6 132.1 9c19.6 7.8 34.7 22.9 42.6 42.6 11.7 29.5 9 99.5 9 132.1s2.7 102.7-9 132.1z"/>
              </svg>
            </a>
            <a href="#" target="_blank">
              <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 640 512">
                <path d="M579.8 267.7c56.5-56.5 56.5-148 0-204.5c-50-50-128.8-56.5-186.3-15.4l-1.6 1.1c-14.4 10.3-17.7 30.3-7.4 44.6s30.3 17.7 44.6 7.4l1.6-1.1c32.1-22.9 76-19.3 103.8 8.6c31.5 31.5 31.5 82.5 0 114L422.3 334.8c-31.5 31.5-82.5 31.5-114 0c-27.9-27.9-31.5-71.8-8.6-103.8l1.1-1.6c10.3-14.4 6.9-34.4-7.4-44.6s-34.4-6.9-44.6 7.4l-1.1 1.6C206.5 251.2 213 330 263 380c56.5 56.5 148 56.5 204.5 0L579.8 267.7zM60.2 244.3c-56.5 56.5-56.5 148 0 204.5c50 50 128.8 56.5 186.3 15.4l1.6-1.1c14.4-10.3 17.7-30.3 7.4-44.6s-30.3-17.7-44.6-7.4l-1.6 1.1c-32.1 22.9-76 19.3-103.8-8.6C74 372 74 321 105.5 289.5L217.7 177.2c31.5-31.5 82.5-31.5 114 0c27.9 27.9 31.5 71.8 8.6 103.9l-1.1 1.6c-10.3 14.4-6.9 34.4 7.4 44.6s34.4 6.9 44.6-7.4l1.1-1.6C433.5 260.8 427 182 377 132c-56.5-56.5-148-56.5-204.5 0L60.2 244.3z"/>
              </svg>
            </a>
          </div>
        </div>
      </article>
    </div>
  </section>
</template>

<style>
.home__banner{
  width: 100%;
}
.section {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: auto;
}
.card {
  display: flex;
  gap: 2rem;
  margin: 1rem 20%;
  padding: 2rem;
  background-color: rgb(245, 172, 129, 0.5);
  border-radius: 0.5rem;
  box-shadow: 4px 7px 16px 0px rgb(245, 172, 129, 0.2);
}
.card__img{
  border-radius: 0.2rem;
  max-width: 20vw;
  max-height: 20vh;
}
.card__img2{
  border-radius: 0.5rem;
  max-width: 20vw;
  max-height: 20vh;
  order: 2;
}
.card__info--name{
  font-size: 1.5rem;
  font-weight: bold;
  color: var(--pink-color);
  margin-bottom: 1rem;
}
.card__info--description {
  margin-bottom: 1rem;
}
.card__info--titles {
  list-style: disc;
  list-style-position: inside;
  margin-bottom: 1rem;
  padding: 0 1rem;
}
.location {
  margin: 2rem 0;
}
.location__title {
  font-size: 3rem;
  font-weight: bolder;
  color: var(--green-color);
  text-align: center;
  margin-bottom: 2rem;
}
.location__info {
  display: flex;
  justify-content: center;
  gap: 3rem;
}
.info__icon {
  display: flex;
  gap: 0.5rem;
  margin: 1rem;
}
.list__planner {
  margin: 1rem;
}
</style>