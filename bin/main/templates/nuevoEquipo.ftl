<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid">
            <h1 class="mt-4">${mainHeader}</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">${pathHeader}</li>
            </ol>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i>Agregar Nuevo Articulo</div>
                <div class="card-body">
                    <form action="/crearArticuloAndItem/" method="post">
                        <div class="row">
                            <div class="col-xl-2 col-md-6">
                                <label id="lbl-cliente">Cliente</label>
                                <select class ="form-control form-control-sm" id="cliente" name="cliente">
                                    <option value="0">- Elija el Cliente -</option>
                                </select>
                            </div>
                            <!-- Estado definido por el servicio -->
                            <!-- Fecha inicial definida por el servicio -->
                            <div class="col-xl-3 col-md-6">
                                <label id="lb-fecha-devolucion">Fecha de Devolucion</label>
                                <input id="fecha-devolucion" name="fecha-devolucion" type="date" class="form-control form-control-sm">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="card mb-4">
                <div class="card-header"><i class="fas fa-table mr-1"></i>Lista de Equipos</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Marca</th>
                                <th>Modelo</th>
                                <th>Descripcion</th>
                                <th>Existencia</th>
                                <th>Costo Diario</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Marca</th>
                                <th>Modelo</th>
                                <th>Descripcion</th>
                                <th>Existencia</th>
                                <th>Costo Diario</th>
                            </tr>
                            </tfoot>
                            <tbody>
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