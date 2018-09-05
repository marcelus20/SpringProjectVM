(()=>{

    const ajax = function (
        url,
        method = "GET",
        contentType = "application/x-www-form-urlenconded",
        format = "json",
        params = {}
        ){

        return new Promise (function (resolve, reject){
            const xhr = new XMLHttpRequest();

            xhr.onreadystatechange = function(){
                if(this.readyState === 4){
                    if(this.status === 200){
                        if(format === "json"){
                            resolve(JSON.parse(this.response));
                        }else{
                            resolve(this.response);
                        }
                    }else{
                        reject(new Error(this.statusText));
                    }
                }
            }

            xhr.onerror = function(){
                reject(new Error(this.statusText));
            }

            xhr.open(method, url, true);
            xhr.setRequestHeader("Content-Type", contentType);
            xhr.send();
        });
    }

    const loadDataFromServer = function (){

        ajax("/greetingJson")
            .then(response => {
                const id = document.getElementById("id");
                const text = document.getElementById("text");

                id.innerHTML = response.id;
                text.innerHTML = response.content;
            })
            .catch(e => console.log(e));
}

    loadDataFromServer();
})();