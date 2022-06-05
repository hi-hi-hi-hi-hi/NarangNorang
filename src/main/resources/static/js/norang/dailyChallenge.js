function setThumbnail(event) {
	var reader = new FileReader();
	reader.onload = function(event) {
		var img = document.createElement("img");
		img.setAttribute("src", event.target.result);
		img.setAttribute("style", 'position: relative; width:400px; height: 400px; text-align: center;');
		document.querySelector("#img_container").appendChild(img);
	};

	reader.readAsDataURL(event.target.files[0]);
}

function dataSubmit() {
	if(confirm("업로드 하시겠습니까?")){
		alert("업로드 완료");
	}else{
		event.preventDefault();
	}
}
