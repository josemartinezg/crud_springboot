<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Rent it!</title>
    <link href="/css/styles.css" rel="stylesheet" />
    <link href="/css/register.css" rel="stylesheet" />
</head>
<!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->

<body>
<div class="container">
    <div class="row">
        <div class="col-lg-10 col-xl-9 mx-auto">
            <div class="card card-signin flex-row my-5">
                <div class="card-img-left d-none d-md-flex">
                    <!-- Background image for card set in CSS! -->
                </div>
                <div class="card-body">
                    <h5 class="card-title text-center">Register</h5>
                    <form id="form" method="post" action="/register/registrarUsuario">
                        <div class="form-label-group">
                            <label for="username">Username</label>
                            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
                        </div>

                        <div class="form-label-group">
                            <label for="email">Email address</label>
                            <input type="email" id="email" name="email" class="form-control" placeholder="Email address" required>
                        </div>

                        <div class="form-label-group">
                            <label for="nombre">Name</label>
                            <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Email address" required>
                        </div>

                        <hr>

                        <div class="form-label-group">
                            <label for="password">Password</label>
                            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
                        </div>

                        <div class="form-label-group">
                            <label for="confirmPassword">Confirm password</label>
                            <input type="password" id="confirmPassword" class="form-control" placeholder="Password" required>
                        </div>

                        <button class="btn btn-lg btn-primary btn-block " type="submit">Register</button>
                        <a class="d-block text-center mt-2 small" href="/login">Log in</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>