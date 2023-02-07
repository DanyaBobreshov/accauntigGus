<#import "blocks/template.ftlh" as t>
<@t.template user>
<regiment>
<ht>
<form action="/editRegiment/${regiment.id}" method="post">
	<div class="form-group">
    		<label for="Title">Наименование</label>
    		<input type="text" value="${regiment.title}" required class="form-control"
    		id="Title" name="Title">
    	</div>

    	<div class="form-group">
    		<label for="Address">Адрес</label>
    		<input type="text" value="${regiment.address}" required class="form-control"
    		id="Address" name="Address">
    	</div>
    	<div class="form-group">
    		<label for="Telephone">Телефон</label>
    		<input type="text" value="${regiment.telephone}" required class="form-control"
    		id="Telephone" name="Telephone">
    	</div>
    	<div class="form-group">
    		<label for="Comment">Примечание</label>
    		<input type="text"  value="${regiment.comment}" required class="form-control"
    		id="Comment" name="Comment">
    	</div>
    	<div class="form-group">
    	<label for="DivisionID"><a href="/divisions">ОВУ</a></th></label>
    	<input type="Long"  value="${regiment.division.id}" required class="form-control"
    	id="DivisionID" name="DivisionID">
    	</div>

	<input type="hidden" name="_csrf" value="${_csrf.token}"/>
     <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
    </form>
    </>
    </@t.template>