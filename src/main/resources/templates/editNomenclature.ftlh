<#import "blocks/template.ftlh" as t>
<@t.template user>
<nomenclature>
<hr>
<form action="/editNomenclature/${nomenclature.id}" method="post">
	<div class="form-group">
		<label for="title">Наименование</label>
		<input type="text" value="${nomenclature.title}" required class="form-control"
		id="title" name="title">
	</div>
               <input type="hidden" name="_csrf" value="${_csrf.token}"/>
   <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
</form>
</>
</@t.template>