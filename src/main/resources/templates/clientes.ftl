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
                        <form id="form" action="/crearCliente" method="post" enctype="multipart/form-data">
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="cedula">Cedula</label>
                                        <input type="text" class="form-control" id="cedula" name="cedula" placeholder="Cedula" required>
                                    </div>
                                </div>
                                <div class="col-xl-2 col-md-6">
                                    <label id="lbl-imagen-eq">Imagen</label>
                                    <input id="imagen" name="imagen" type="file" class="form-control-file form-control-sm">
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre del Cliente" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="apellido">Apellido</label>
                                        <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Apellido del Cliente" required>
                                    </div>
                                </div>
                            </div>
                            <input id="id" name="id" value="" hidden/>
                            <div class="row justify-content-sm-start">
                                <div class="col col-sm-1">
                                    <a href="/agregar-cliente"><button class="btn btn-success" type="submit">Agregar</button></a>
                                </div>
                                <div class="col col-sm-1">
                                    <a><button class="btn btn-dark" onclick="limpiarForm()">limpiar</button></a>
                                </div>
                            </div>
                        </form>
                    <#else>
                        <form id="form" action="/crearCliente" method="post" enctype="multipart/form-data">
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="cedula">Cedula</label>
                                        <input type="text" class="form-control" id="cedula" name="cedula" value="${clienteEditado.cedula}" placeholder="Cedula" required>
                                    </div>
                                </div>
                                <div class="col-xl-2 col-md-6">
                                    <label id="lbl-imagen-eq">Imagen</label>
                                    <input id="imagen" name="imagen" type="file"  class="form-control-file form-control-sm">
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" id="nombre" name="nombre" value="${clienteEditado.nombre}" placeholder="Nombre del Cliente" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="apellido">Apellido</label>
                                        <input type="text" class="form-control" id="apellido" name="apellido" value="${clienteEditado.apellido}" placeholder="Apellido del Cliente" required>
                                    </div>
                                </div>
                            </div>
                            <div class="row justify-content-sm-start">
                                <div class="col col-sm-1">
                                    <a><button class="btn btn-warning" type="submit">Salvar</button></a>
                                </div>
                                <div class="col col-sm-1">
                                    <a><button class="btn btn-dark" onclick="limpiarForm()">limpiar</button></a>
                                </div>
                            </div>
                            <input id="id" name="id" value="${clienteEditado.id}" hidden/>
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
                                <th>Foto</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Cedula</th>
                                <th>Ver Alquileres</th>
                                <th>Acciones</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Foto</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Cedula</th>
                                <th>Ver Alquileres</th>
                                <th>Acciones</th>
                            </tr>
                            </tfoot>
                            <tbody>
                                <#list clientes as cliente>
                                    <tr>
                                        <td>
                                            <img src="data:image/png;base64, ${cliente.fotoDePeril}"
                                                 height="80"
                                                 width="80">
                                        </td>
                                        <td>${cliente.nombre}</td>
                                        <td>${cliente.apellido}</td>
                                        <td>${cliente.cedula}</td>
                                        <td>Ver Alquileres</td>
                                        <td>
                                            <div class="row justify-content-center align-content-center">
                                                <div class="">
                                                    <form action="/editar-cliente" method="get">
                                                        <input id="id" name="id" value="${cliente.id}" hidden>
                                                        <button type="submit" class="btn btn-outline-warning">Editar</button>
                                                    </form>
                                                </div>
                                                <div class="">
                                                    <!-- Button trigger modal -->
                                                    <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#staticBackdrop">
                                                        Eliminar
                                                    </button>
                                                    <!-- Modal -->
                                                    <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h4 class="modal-title" id="staticBackdropLabel">Eliminar</h4>
                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <strong>¿Esta seguro de eliminar el cliente <span class="badge badge-danger"> ${cliente.nombre} ${cliente.apellido}</span>? Borraría toda la información relacionada.</strong>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                                    <form action="/eliminar-cliente">
                                                                        <input id="id" name="id" value="${cliente.id}" hidden>
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