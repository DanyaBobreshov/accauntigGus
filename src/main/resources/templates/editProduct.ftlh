<#import "blocks/template.ftlh" as t>
<@t.template user>
<nomenclature>
<ht>
<form action="/editProduct/${product.id}" method="post">
	<div class="form-group">
		label for="title">Наименование</label>
		<input type="text" value="${product.title}" required class="form-control"
		id="title" name="title">
	</div>

	<div class="form-group">
	<label for="Module">Единица измерения</label>
	<input type="text" value="${product.module}" required class="form-control"
	id="Module" name="Module">
	</div>
	<div class="form-group">
	<label for="Year">Год</label>
	<input type="Long" value="${product.year}" required class="form-control"
	id="Year" name="Year">
	</div>
	<div class="form-group">
	<label for="Comment">Примечание</label>
	<input type="text" value="${product.comment}" required class="form-control"
	id="Comment" name="Comment">
	</div>
	<div class="form-group">
	<label for="NomenclatureID">ID Номенклатуры</label>
	<input type="Long" value="${product.nomenclature.id}" required class="form-control"
	id="NomenclatureID" name="NomenclatureID">
		<a href="/allNomenclature">Номенклатуры</a></th>
	</div>
		<input type="hidden" name="_csrf" value="${_csrf.token}"/>
         <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
</form>
</>
</@t.template>