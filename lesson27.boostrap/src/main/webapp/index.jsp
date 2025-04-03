<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Spider-Man - Your Friendly Neighborhood Hero</title>
    <!-- Bootstrap CSS via CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .hero-image {
            background-image: url('https://images.unsplash.com/photo-1635805737707-575885ab0820?ixlib=rb-4.0.3');
            background-size: cover;
            background-position: center;
            height: 400px;
            color: white;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
            margin-bottom: 30px;
        }
        .spider-card {
            transition: transform 0.3s;
        }
        .spider-card:hover {
            transform: scale(1.05);
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-danger sticky-top">
    <div class="container">
        <a class="navbar-brand" href="#">Spider-Man</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#about">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#powers">Powers</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="hero-image">
    <div class="bg-dark bg-opacity-75 p-4 rounded">
        <h1 class="display-4">Spider-Man</h1>
        <p class="lead">Your Friendly Neighborhood Superhero</p>
    </div>
</div>


<div class="container">
    <section id="about" class="mb-5">
        <h2 class="text-center mb-4">About Spider-Man</h2>
        <div class="row">
            <div class="col-md-6">
                <img src="https://images.unsplash.com/photo-1608889175123-8ee362201f81" alt="Spider-Man" class="img-fluid rounded mb-3">
            </div>
            <div class="col-md-6">
                <p>Spider-Man, also known as Peter Parker, is a fictional superhero created by writer Stan Lee and artist Steve Ditko. He first appeared in the comic book Amazing Fantasy #15 in August 1962.</p>
                <p>Peter Parker is a high school student who gets bitten by a radioactive spider and gains spider-like abilities. After the tragic death of his Uncle Ben, Peter learns that "with great power comes great responsibility."</p>
                <div class="alert alert-info">
                    <strong>Did you know?</strong> Spider-Man is one of the most popular and commercially successful superheroes.
                </div>
            </div>
        </div>
    </section>


    <section id="powers" class="mb-5">
        <h2 class="text-center mb-4">Spider-Man's Powers</h2>
        <div class="row">
            <div class="col-md-4 mb-4">
                <div class="card spider-card h-100">
                    <div class="card-body">
                        <h5 class="card-title">Wall-Crawling</h5>
                        <p class="card-text">Spider-Man can cling to most surfaces, allowing him to scale walls and ceilings with ease.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="card spider-card h-100">
                    <div class="card-body">
                        <h5 class="card-title">Spider-Sense</h5>
                        <p class="card-text">A precognitive danger sense that alerts him to potential threats before they happen.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="card spider-card h-100">
                    <div class="card-body">
                        <h5 class="card-title">Web-Shooters</h5>
                        <p class="card-text">Mechanical devices that shoot strong, adhesive webbing that Spider-Man uses to swing between buildings.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <section class="mb-5 text-center">
        <blockquote class="blockquote">
            <p>"With great power comes great responsibility."</p>
            <footer class="blockquote-footer">Uncle Ben in <cite>Amazing Fantasy #15</cite></footer>
        </blockquote>
    </section>
</div>


<footer class="bg-dark text-white py-4">
    <div class="container text-center">
        <p>@ 2025 Spider-Man Fan Page</p>
        <p>Created with Bootstrap 5</p>
    </div>
</footer>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>