let value = JSON.parse(localStorage.getItem('items'));

const updateStorage = () => value = JSON.parse(localStorage.getItem('items'));

const newElement = () => {
    let inputDOM = document.querySelector("#task").value;

    if (inputDOM) {
        if (value != null && value.includes(inputDOM)) {
            $(".error").toast("show");
        }
        else {
            createLI(inputDOM);

            if (value) {
                if (typeof(value) == "object")
                    value.push(inputDOM);
                else
                    value = [value, inputDOM];

                localStorage.setItem('items', JSON.stringify(value));
            }
            else {
                let inputArray = [inputDOM];
                localStorage.setItem('items', JSON.stringify(inputArray));
                updateStorage();
            }
            $(".success").toast("show");
        }
    }
    else {
        $(".error").toast("show");
    }
}

const createLI = (input, status=false) => {
    let liDOM = document.querySelector("#list");
    let newElementDOM = document.createElement("li");
    newElementDOM.classList.add("markable");
    if (status)
        newElementDOM.classList.add("checked");
    const appendContent = `${input} <span class="close" onclick="removeElement(event)">×</span>`
    newElementDOM.innerHTML = appendContent;
    liDOM.appendChild(newElementDOM);
}

const startupTaskLoader = () => {
    updateStorage();
    if (value) {
        if (typeof(value) == "object") {
            for (let i = 0; i < value.length; i++) {
                let task = value[i];
                if (localStorage.getItem(task))
                    createLI(task, true);
                else
                    createLI(task)
            }
        }
        else {
            if (localStorage.getItem(value))
                createLI(value, true);
            else
                createLI(value);
        }

        updateStorage();
    }
}

startupTaskLoader();

const removeElement = event => {
    let targetElement = event.target.innerHTML;

    if (typeof(value) == "object") {
        value.splice(value.indexOf(targetElement));
        localStorage.setItem('items', JSON.stringify(value));
    }
    else {
        localStorage.clear();
    }
    
    updateStorage();
    
    event.target.parentElement.remove();
}

document.addEventListener('click', function(event) {
    if (event.target.classList.contains("markable")) {
        let variable = event.target.innerHTML.slice(0, event.target.innerHTML.indexOf(' <'));
        if (event.target.classList.contains("checked")) {
            event.target.classList.remove("checked");
            localStorage.removeItem(variable);
        }
        else {
            event.target.classList.add("checked");
            localStorage.setItem(variable, "true");
        }
    }
});

