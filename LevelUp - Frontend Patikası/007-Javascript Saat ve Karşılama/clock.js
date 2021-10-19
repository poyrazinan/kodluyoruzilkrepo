/**
 * Prompt request for user name
 */
const promptTask = () => {
    let name;
    while (!Boolean(name)) {
        name = prompt("Adınızı girin:")
    }
    document.querySelector("#myName").innerHTML = name;
    // Interval starter for clock after name accepted.
    setInterval(showTime, 1000);
}

/**
 * Main function for time interval
 */
const showTime = () => {
    let clockDOM = document.querySelector('#myClock');
    const date = new Date();
    let time = numberFormatter(date.getHours()) + ":" + numberFormatter(date.getMinutes()) + ":" + numberFormatter(date.getSeconds()) + " " + days[date.getDay()];
    clockDOM.innerHTML = time;
}

// Day array for getting day
const days = {
    0: "Pazar",
    1: "Pazartesi",
    2: "Salı",
    3: "Çarşamba",
    4: "Perşembe",
    5: "Cuma",
    6: "Cumartesi"
}

/**
 * Date value returns single digit if smaller then 10.
 * This function converts the digit to double digit count.
 */
const numberFormatter = timeKey => {
    return (timeKey < 10) ? "0" + timeKey : timeKey;
}

// First task
promptTask();