/*Fetch data*/
function get(action, id) {
	document.getElementById("loader").style.display='inline-block';
	fetch(action)
		.then(resp => resp.text())
		.then(data => {
			document.getElementById("loader").style.display='none';
			document.getElementById(id).innerHTML = data;
			const c = document.getElementById('country');
			if(c!==null && c.value === 'none'){
				call();
			}
		}).catch(error => console.log(error));
	
}
/*end Fetch data*/

/*Toggle Menu*/
function toggleMenu() {
	var sideMenu = document.getElementById("sideMenu");
	var mainContent = document.getElementById("main-content");

	if (sideMenu.style.width === "200px") {
		sideMenu.style.width = "0";
		mainContent.style.marginLeft = "0";
	} else {
		sideMenu.style.width = "200px";
		mainContent.style.marginLeft = "200px";
	}
}
/*End toggle menu*/
/*for getting Address */
function call() {
    const countrySelect = document.getElementById('country');
    const stateSelect = document.getElementById('state');
    const citySelect = document.getElementById('city');

    async function fetchCountries() {
        try {
            const response = await fetch('https://restcountries.com/v3.1/all');
            const countries = await response.json();
            populateSelect(countrySelect, countries.map(country => country.name.common).sort());
        } catch (error) {
            console.error('Error fetching countries:', error);
        }
    }

    async function fetchStates(country) {
        try {
            const response = await fetch('https://countriesnow.space/api/v0.1/countries/states', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ country }),
            });
            const data = await response.json();
            if (data.error) {
                throw new Error(data.msg);
            }
            populateSelect(stateSelect, data.data.states.map(state => state.name).sort());
        } catch (error) {
            console.error('Error fetching states:', error);
            stateSelect.innerHTML = '';
        }
    }

    async function fetchCities(state) {
        try {
            const response = await fetch('https://countriesnow.space/api/v0.1/countries/state/cities', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    country: countrySelect.value,
                    state,
                }),
            });
            const data = await response.json();
            if (data.error) {
                throw new Error(data.msg);
            }
            populateSelect(citySelect, data.data.map(city => city).sort());
        } catch (error) {
            console.error('Error fetching cities:', error);
            citySelect.innerHTML = '';
        }
    }

    function populateSelect(selectElement, options) {
        selectElement.innerHTML = '';
        options.forEach(option => {
            const opt = document.createElement('option');
            opt.value = option;
            opt.text = option;
            selectElement.appendChild(opt);
        });
    }

    fetchCountries();

    countrySelect.addEventListener('change', function() {
        fetchStates(countrySelect.value);
        citySelect.innerHTML = '';
    });

    stateSelect.addEventListener('change', function() {
        fetchCities(stateSelect.value);
    });
}
   
/* End getting Address*/

/*submit form*/
async function submit(event,action,formId, reload){
	event.preventDefault();
	document.getElementById("loader").style.display='inline-block';
	const form = document.getElementById(formId);
	const formData = new FormData(form);
	const formEntires =Object.fromEntries(formData.entries());
	for(let[key,value] of formData.entries()){
		if(value instanceof File){
			formEntires[key] ={
				fileName: value.name,
				fileType: value.type,
				base64Data: await toBase64(value)				
			} 
		}
	}
	const formJSON = JSON.stringify(formEntires);
	try{
		const response = await fetch(action, {
			method: 'POST',
			headers: {
				'Content-Type':'application/json'
			},
			body: formJSON
		});
		document.getElementById("loader").style.display='none';
		if(response.ok){	
			const result = await response.json();
			popup(result['status'],result['message'],reload,result['status'].toLowerCase());
		}
		else{
			popup(response.status,'Response in not ok',reload,'error');
		}
		
	}catch(error){
		document.getElementById("loader").style.display='none';
		popup("Error",error,reload,'error');

	}
}
//Utility function to convert a file to Base64
function toBase64(file){
	return new Promise((resolve,reject)=>{
		const reader = new FileReader();
		reader.readAsDataURL(file);
		reader.onload=()=>resolve(reader.result);
		reader.onerror = error=>reject(error);
	});
}

//select branch row in deleteBranch Page 
function selectRow(id){
	var tr = document.getElementById(id);
	if(tr.getAttribute('select')==='no'){		
	tr.style.boxShadow='inset 0px 0px 20px #ff2828';
	tr.style.borderRadius='15px';
	tr.setAttribute('select','yes');
	}
	else{
		tr.style.boxShadow='none';
		tr.style.borderRadius='0px';
		tr.setAttribute('select','no');
	}
}


function deleteRow(action,reload){
	var selectedRow = document.querySelectorAll(".table tr[select='yes']");
	var ids=[];
	selectedRow.forEach(row=>{
		var id = row.getAttribute('id');
		if(id)ids.push(id);
	});
	
	fetch(action,{
		method:'POST',
		headers:{
			'Content-Type':'application/json'
		},
		body:JSON.stringify({ids: ids})
	})
	.then(resp=>resp.json())
	.then(data=>{
		if(data['status'].toLowerCase()==='success'){
			popup(data['status'],data['message'],reload);		
		}else{
			popup(data['status'],data['message'],reload,data['status'].toLowerCase());	
		}
	})
	.catch(error=>{
		console.log("Error: ",error)
	})
}
function popup(head,message,reload,status){
	const popup = document.getElementById('popup');
	const popupHead = document.getElementById('popupHead');
	const popupMessage = document.getElementById('popupMessage');
	popupHead.innerHTML=head;
	popupMessage.innerHTML=message;
	popup.style.display='block';
	if(status==='error'){
		popup.style.color='#F44336';
		popup.style.borderColor='#F44336';
		popup.style.boxShadow='1px 1px 5px #8e0000b3';
	}else{
		popup.style.color='#00a307';
		popup.style.borderColor='#00a807';
		popup.style.boxShadow='1px 1px 5px #008e19b3';
	}
	setTimeout(()=>{
		popup.style.display='none';
		get(reload,'page-content');	
	},2000);
}

//send java object to another page
function send(rowId,action, id) {
	document.getElementById("loader").style.display='inline-block';
	var data = document.getElementById(rowId).getAttribute('data');
	console.log(data)
	fetch(action,{
		method: 'POST',
		headers: {
				'Content-Type':'application/json'
		},
		body:data
	})
		.then(resp => resp.text())
		.then(data => {
			document.getElementById("loader").style.display='none';
			document.getElementById(id).innerHTML = data;
			const c = document.getElementById('country');
			if(c!==null && c.value === 'none'){
				call();
			}
		}).catch(error =>{
			console.log(error)
			document.getElementById("loader").style.display='none';

		} );
	
}
