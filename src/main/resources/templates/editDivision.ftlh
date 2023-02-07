<#import "blocks/template.ftlh" as t>
<@t.template user>
<division>
<ht>
<form action="/editDivision/${division.id}" method="post">
	<div class="form-group">
		<label for="Title">Наименование</label>
		<input type="text"  value="${division.title}" required class="form-control"
		id="Title" name="Title">
	</div>
	<div class="form-group">
		<label for="Address">Адрес</label>
		<input type="text" value="${division.address}" required class="form-control"
		id="Address" name="Address">
	</div>
	<div class="form-group">
		<label for="Telephone">Телефон</label>
		<input type="text" value="${division.telephone}" required class="form-control"
		id="Telephone" name="Telephone">
	</div>
	<div class="form-group">
		<label for="TOSotdel">Отдел ТОС</label>
		<input type="text" value="${division.TOSOtdel}" required class="form-control"
		id="TOSotdel" name="TOSotdel">
	</div>

    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
   <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
</form>
</>
</@t.template>