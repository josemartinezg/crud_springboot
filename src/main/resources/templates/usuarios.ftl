<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid">
            <h1 class="mt-4">${mainHeader}</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">${pathHeader}</li>
            </ol>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i>Agregar Nuevo Cliente</div>
                <div class="card-body">
                    <#if edicion != 1>
                        <form id="form" action="/usuarios/registrarUsuario" method="post">
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="username">Username</label>
                                        <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="password">Password</label>
                                        <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre de usuario" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="text" class="form-control" id="email" name="email" placeholder="Email" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <label for="rol">Rol del usuario</label>
                                    <select class="custom-select" id="rol" name="rol" required>
                                        <#list roles as rol>
                                            <option value="${rol.role}">${rol.role}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <div class="custom-checkbox">
                                            <label class="custom-control-label" for="activo">Activo</label>
                                            <input type="checkbox" class="custom-control-input" id="activo" name="activo" checked>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <input id="id" name="id" value="" hidden/>
                            <div class="row justify-content-sm-start">
                                <div class="col col-sm-1">
                                    <a href="/usuarios/registrarUsuario"><button class="btn btn-success" type="submit">Agregar</button></a>
                                </div>
                                <div class="col col-sm-1">
                                    <a><button class="btn btn-dark" onclick="limpiarForm()">limpiar</button></a>
                                </div>
                            </div>
                        </form>
                    <#else>
                        <form id="form" action="/usuarios/registrarUsuario" method="post">
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="username">Username</label>
                                        <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="password">Password</label>
                                        <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre de usuario" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="text" class="form-control" id="email" name="email" placeholder="Email" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <label for="rol">Rol del usuario</label>
                                    <select class="custom-select" id="rol" name="rol" required>
                                        <#list roles as rol>
                                            <option value="${rol.role}">${rol.role}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <div class="custom-checkbox">
                                            <label class="custom-control-label" for="activo">Activo</label>
                                            <input type="checkbox" class="custom-control-input" id="activo" name="activo" checked>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <input id="id" name="id" value="" hidden/>
                            <div class="row justify-content-sm-start">
                                <div class="col col-sm-1">
                                    <a href="/usuarios/registrarUsuario"><button class="btn btn-success" type="submit">Agregar</button></a>
                                </div>
                                <div class="col col-sm-1">
                                    <a><button class="btn btn-dark" onclick="limpiarForm()">limpiar</button></a>
                                </div>
                            </div>
                        </form>
                    </#if>
                </div>
            </div>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i>Lista de clientes</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Username</th>
                                <th>Nombre</th>
                                <th>Email</th>
                                <th>Rol</th>
                                <th>Activo</th>
                                <th>Acciones</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Username</th>
                                <th>Nombre</th>
                                <th>Email</th>
                                <th>Rol</th>
                                <th>Activo</th>
                                <th>Acciones</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <#list usuarios as usuario>
                                <tr>
                                    <td>${usuario.username}</td>
                                    <td>${usuario.nombre}</td>
                                    <td>${usuario.email}</td>
                                    <td>
                                        <#list usuario.roles as rol>
                                            <a>${rol.role}</a>
                                        </#list>
                                    </td>
                                    <td>
                                        <#if usuario.activo>
                                            <a class="badge badge-info">Activo</a>
                                        <#else>
                                            <a class="badge badge-danger">Inactivo</a>
                                        </#if>
                                    </td>
                                    <td>
                                        <div class="row justify-content-center align-content-center">
                                            <div class="">
                                                <form action="/editar-cliente" method="get">
                                                    <input id="id" name="id" value="${usuario.username}" hidden>
                                                    <button type="submit" class="btn btn-outline-warning">Editar</button>
                                                </form>
                                            </div>
                                            <div class="">
                                                <!-- Button trigger modal -->
                                                <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#staticBackdrop">
                                                    Eliminar
                                                </button>
                                                <!-- Modal -->
                                                <div class="modal fade" id="staticBackdrop${usuario.username}"
                                                     data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h4 class="modal-title" id="staticBackdropLabel">Eliminar</h4>
                                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                    <span aria-hidden="true">&times;</span>
                                                                </button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <strong>¿Esta seguro de eliminar el cliente <span class="badge badge-danger"> ${usuario.username}</span>? Borraría toda la información relacionada.</strong>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                                <form action="/eliminar-cliente">
                                                                    <input id="id" name="id" value="${usuario.username}" hidden>
                                                                    <button type="submit" class="btn btn-outline-danger">Eliminar</button>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer class="py-4 bg-light mt-auto">
        <div class="container-fluid">
            <div class="d-flex align-items-center justify-content-between small">
                <div class="text-muted">${copyRight}</div>
                <div>
                    <a href="#">Privacy Policy</a>
                    &middot;
                    <a href="#">Terms &amp; Conditions</a>
                </div>
            </div>
        </div>
    </footer>
</div>