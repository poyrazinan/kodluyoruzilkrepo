
function searchEvent() {
  let input = document.querySelector("#search");
  if (input.value) {
    window.location.assign(`https://google.com/search?q=${input.value}`)
  }
}

function keyupEvent(event) {
  if (event.keyCode === 13) {
    event.preventDefault();
    searchEvent();
  }
}

function feelLuckyEvent() {
  window.location.assign("https://www.google.com/doodles");
}

function signInEvent() {
  window.location.assign("https://accounts.google.com/signin");
}