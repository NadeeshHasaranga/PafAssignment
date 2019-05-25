 
function emptyCheck(name, id) {
	var inputValue = document.getElementById(name);
	if (inputValue.value == "" || inputValue.value == null
			|| inputValue.value == " ") {
		id.style.backgroundColor = "red";
	} else {
		id.style.backgroundColor = "";
	}
}


function priceValidation(price, id) {

	var regExpression = /[0-9]/;

	if (!regExpression.test(price)) {
		id.style.backgroundColor = "red";
		alert("Price Invalid")
	} else {
		value.style.backgroundColor = "";
	}

function validateForm() {

		var Id = document.getElementById('id');
		var name = document.getElementById('name');
		var price = document.getElementById('price');
		var quantity = document.getElementById('quantity');
		var category = document.getElementById('category');
		var brand = document.getElementById('brand');

		priceValidation(price.value, id);
		//emailValidation(Email.value, id);
		//mobileValidation(Mobile.value, id);
	}

}

