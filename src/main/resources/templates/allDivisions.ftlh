<#import "blocks/template.ftlh" as t>
<@t.template user>
<h1 style="text-align: center">Органы военного управления</h1><hr>
	<table class="table table-hober table-dark">
		<tr>
			<th score="col">id</th>
			<th score="col">Наименование</th>
			<th score="col">Адрес</th>
			<th score="col">Телефон</th>
			<th score="col">Отдел ТОС</th>
		</tr>
		<#list divisions as division>
		<tr>
			<th>${division.id}</th>
			<th>${division.title}</th>
			<th>${division.address}</th>
			<th>${division.telephone}</th>
			<th>${division.TOSOtdel}</th>
			<th><a href="/editDivision/${division.id}">Редактирование</a></th>
			<th><a href="/deleteDivision/${division.id}">Удаление</a></th>
		</tr>
		<#else>
		<h3>нет</h3>
		</#list>
	</table>

<form method="get" action="/divisions">
	<div class="form-group col-md-10">
		<label for="searchWord">Поиск</label>
		<input type="text" name="searchWord" <#if searchWord??>value="${searchWord}"</#if> class="form-control" id="searchWord">
	</div>

	<button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
</form>
<hr>
<hr>
	<a class="btn btn-dark mt-3 mb-3" style="text-align: canter; width:100%" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="true" aria-controls="collapseExample">
		Добавление новой организации
	</a>
	<div class="collapse md-3" id="collapseExample" style="">
	<form action="/addDivision" method="post" enctype="multipart/form-data">

	<div class="form-group">
		<label for="Title">Наименование</label>
		<input type="text" required class="form-control"
		id="Title" name="Title">
	</div>

	<div class="form-group">
		<label for="Address">Адрес</label>
		<input type="text" required class="form-control"
		id="Address" name="Address">
	</div>
	<div class="form-group">
		<label for="Telephone">Телефон</label>
		<input type="text" required class="form-control"
		id="Telephone" name="Telephone">
	</div>
	<div class="form-group">
		<label for="TOSotdel">Отдел ТОС</label>
		<input type="text" required class="form-control"
		id="TOSotdel" name="TOSotdel">
	</div>
	</div>
	<div class="form-group">

	<input type="hidden" name="_csrf" value="${_csrf.token}"/>

     <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
		</form>
	</form>
	</div>
</@t.template>
