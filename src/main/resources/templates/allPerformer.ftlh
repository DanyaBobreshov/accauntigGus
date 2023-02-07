<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Первые исполнители</h1><hr>
     <table class="table table-hover table-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">Должность</th>
                    <th scope="col">Фамилия, инициалы</th>
                </tr>
                <#list performers as performer>
                <tr>
                    <th>${performer.id}</th>
                    <th>${performer.rang}</th>
                    <th>${performer.name}</th>
                    <th><a href="/editPerformer/${performer.id}">Редактировние</a></th>
                    <th><a href="/deletePerformer/${performer.id}">Удаление</a></th>
                </tr>
                <#else>
                <h3>Исполнителей нет</h3>
            </#list>
            </table>
    <form method="get" action="/allPerformer">
            <div class="form-group col-md-10">
                <label for="searchWord">Поиск</label>
                <input type="text" name="searchWord" <#if searchWord??>value="${searchWord}"</#if> class="form-control"
                       id="searchWord">
            </div>
            <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
    </form>
    <hr>
 <hr>
    <a class="btn btn-dark mt-3 mb-3" style="text-align: center; width: 100%"
       data-toggle="collapse" href="#collapseExample" role="button"
       aria-expanded="true" aria-controls="collapseExample">
        Добавить
    </a>
    <div class="collapse mb-3" id="collapseExample" style="">
        <form action="/addPerformer" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="Name">Фамилия, инициалы</label>
                <input type="text" required class="form-control"
                       id="Name" name="Name">
            </div>
            <div class="form-group">
                 <label for="Rang">Должность</label>
                 <input type="text" required class="form-control"
                        id="Rang" name="Rang">
             </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
        </form>
 </div>
   </@t.template>