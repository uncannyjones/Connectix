console.log("Script Loaded");


let currentTheme = getTheme();

changeTheme(currentTheme)

function changeTheme(currentTheme){
    
    document.querySelector("html").classList.add(currentTheme);

    //set listener
    const changeThemeButton = document.querySelector("#theme_change_button")
    changeThemeButton.addEventListener("click", (event) => {
        const oldTheme = currentTheme;
        console.log("Change Theme Button Click");
        
        if (currentTheme == "dark"){
            
            currentTheme = "light";

        }else{
            currentTheme = "dark";
        }

        
    });

}

function setTheme(theme){
    localStorage.setItem("theme", theme);
}

function getTheme() {
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}

function changePageTheme(theme){
    setTheme(currentTheme);

    document.querySelector("html").classList.remove(oldTheme);
    document.querySelector("html").classList.add(currentTheme);
    changeThemeButton.querySelector("span").textContent = currentTheme == 'light'?'Dark' : "Light" ;
}