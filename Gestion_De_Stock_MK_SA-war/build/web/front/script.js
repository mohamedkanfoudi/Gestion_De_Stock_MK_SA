var survey_options = document.getElementById('survey_options');
var add_more_fields = document.getElementById('add_more_fields');
var remove_fields = document.getElementById('remove_fields');

add_more_fields.onclick = function(){
    var input_tags = survey_options.getElementsByTagName('input');
    let id=parseInt(input_tags[(input_tags.length) - 1].getAttribute("id"));
    // alert(id);
  var newField = document.createElement('input');
  newField.setAttribute('type','text');
  newField.setAttribute('name','survey_options[]');
  newField.setAttribute('id',id+1);
  newField.setAttribute('class','survey_options');
  newField.setAttribute('siz',50);
  newField.setAttribute('placeholder','médicament');
  
  survey_options.appendChild(newField);
}

remove_fields.onclick = function(){
  var input_tags = survey_options.getElementsByTagName('input');
  if(input_tags.length > 1) {
    survey_options.removeChild(input_tags[(input_tags.length) - 1]);
  }
}