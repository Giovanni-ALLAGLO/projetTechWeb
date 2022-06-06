


let tabs = document.querySelectorAll(".tab-link:not(.desactive)"); 
tabs.forEach((tab) => {
  tab.addEventListener("click", () => {
    unSelectAll();
    tab.classList.add("active");
    let ref = tab.getAttribute("data-ref");
    document
      .querySelector(`.tab-body[data-id="${ref}"]`)
      .classList.add("active");
  });
});

function unSelectAll() {
  tabs.forEach((tab) => {
    tab.classList.remove("active");
  });
  let tabbodies = document.querySelectorAll(".tab-body");
  tabbodies.forEach((tab) => {
    tab.classList.remove("active");
  });
}
document.querySelector(".tab-link.active").click();


/*aller vers la page index.html apres le clic le button id=connexion apres verification du username et du password avec Jquery sur commande get de base de donnee*/
$(document).ready(function(){

  $("#connexion").click(function(){
        var username = $("#username").val();
        var password = $("#password").val();
        $.get("api/personne", function(data){
			console.log(data);
			if(data==null){  alert (" creer un compte");}
            for(var i = 0; i < data.length; i++){
                if(data[i].username == username && data[i].motPasse == password){
                    window.location.href = "index.html";
                    break;
                }
            }
            alert ("username ou password incorrect");
        });
    });

//inscription le username et le password dans la base de donnée avec Jquery
$("#inscription").click(function() {
    var username = $("#username").val();
    var password = $("#password").val();
    var data = {
        username: username,
        motPasse: password
    };
    $.post("http://localhost:8080/api/personne", data, function(data) {
        alert("inscription reussie");
    });
});

});
