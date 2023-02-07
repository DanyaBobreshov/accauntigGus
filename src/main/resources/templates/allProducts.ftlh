<#import "blocks/template.ftlh" as t>
<@t.template user>
	<h1 style="text-align: center">Изделия</h1><hr>
	<table class="table table-hober table-dark">
		<tr>
			<th score="col">id</th>
			<th score="col">Наименование</th>
			<th score="col">Единица измерения</th>
			<th score="col">Год поставки</th>
			<th score="col">Примечание</th>
			<th score="col">Номенклатура</th>
		</tr>
		<#list products as product>
		<tr>
			<th>${product.id}</th>
			<th>${product.title}</th>
			<th>${product.module}</th>
			<th>${product.year}</th>
			<th>${product.comment}</th>
			<th>${product.nomenclature.title}</th>
			<th><a href="/editProduct/${product.id}">Редактирование</a></th>
			<th><a href="/deleteProduct/${product.id}">Удаление</a></th>
		</tr>
		<#else>
		<h3>Изделий нет</h3>
		</#list>
	</table>

<form method="get" action="/allProducts">
	<div class="form-group col-md-10">
		<label for="searchWord">Поиск</label>
		<input type="text" name="searchWord" <#if searchWord??>value="${searchWord}"</#if> class="form-control" id="searchWord">
	</div>

	<button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
</form>
<hr>
<hr>
	<a class="btn btn-dark mt-3 mb-3" style="text-align: canter; width:100%" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="true" aria-controls="collapseExample">
		Добавить новое изделие
	</a>
	<div class="collapse md-3" id="collapseExample" style="">
	<form action="/addProduct" method="post" enctype="multipart/form-data">

	<div class="form-group">
	<label for="Title">Наименование</label>
	<input type="text" required class="form-control"
	id="Title" name="Title">
	</div>

	<div class="form-group">
	<label for="Module">Единица измерения</label>
	<input type="text" required class="form-control"
	id="Module" name="Module">
	</div>
	<div class="form-group">
	<label for="Year">Год</label>
	<input type="Long" required class="form-control"
	id="Year" name="Year">
	</div>
	<div class="form-group">
	<label for="Comment">Примечание</label>
	<input type="text" required class="form-control"
	id="Comment" name="Comment">
	</div>
	<div class="form-group">
	<label for="NomenclatureID">ID Номенклатуры</label>
	<input type="Long" required class="form-control"
	id="NomenclatureID" name="NomenclatureID">
		<a href="/allNomenclature">Номенклатуры</a></th>
	</div>
	</div>
	<input type="hidden" name="_csrf" value="${_csrf.token}"/>
     <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
		</form>
	</form>
	</div>
</@t.template>