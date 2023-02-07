<#import "blocks/template.ftlh" as t>
<@t.template user>
<performer>
    <hr>
        <form action="/editPerformer/${performer.id}" method="post">
    <div class="form-group">
                    <label for="Name">Фамилия, инициалы</label>
                    <input type="text" value="${performer.name}" required class="form-control"
                           id="Name" name="Name">
                </div>
                <div class="form-group">
                     <label for="Rang">Должность</label>
                    <input type="text" value="${performer.rang}" required class="form-control"
                            id="Rang" name="Rang">
                 </div>
               <input type="hidden" name="_csrf" value="${_csrf.token}"/>
               <button type="submit" style="width: 100%" class="btn btn-dark">Редактировать</button>
    </form>
    </>
</@t.template>