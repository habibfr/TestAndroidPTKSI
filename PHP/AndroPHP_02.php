<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
</head>
<body>
  <form method="post">
    <table>
      <tr>
        <td>
          Username
        </td>
        <td>
          <input type="text" id="username" name="username" required>
        </td>
      </tr>

      <tr>
        <td>
          Password
        </td>
        <td>
          <input type="password" id="password" name="password" required>
        </td>
      </tr>

      <tr>
        <td></td>
        <td>
          <input type="submit" value="Login">
        </td>
      </tr>
    </table>
  </form>
</body>
</html>

<?php
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    // Memeriksa apakah password adalah kebalikan dari username
    if (strrev($username) === $password) {
        echo "Login berhasil!";
    } else {
        echo "Login gagal!";
    }
}
?>