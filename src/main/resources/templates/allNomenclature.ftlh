<#import "blocks/template.ftlh" as t>
<@t.template user>
	<h1 style="text-align: center">Номенклатура</h1><hr>
	<table class="table table-hober table-dark">
		<tr>
			<th score="col">id</th>
			<th score="col">Наименование</th>
		</tr>
		<#list nomenclatures as nomenclature>
		<tr>
			<th>${nomenclature.id}</th>
			<th>${nomenclature.title}</th>
			<th><a href="/editNomenclature/${nomenclature.id}">Редактирование</a></th>
			<th><a href="/deleteNomenclature/${nomenclature.id}">Удаление</a></th>
		</tr>
		<#else>
		<h3>Изделий нет</h3>
		</#list>
	</table>

<form method="get" action="/allNomenclature">
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
	<form action="/addNomenclature" method="post" enctype="multipart/form-data">

	<div class="form-group">
	<label for="nomenclatureTitle">Наименование</label>
	<input type="text" required class="form-control"
	id="nomenclatureTitle" name="nomenclatureTitle">
	</div>
	</div>

	<input type="hidden" name="_csrf" value="${_csrf.token}"/>

     <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
    </form>
  </form>
	</form>
	</div>
</@t.template>
