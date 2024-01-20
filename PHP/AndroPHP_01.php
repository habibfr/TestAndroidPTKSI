<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Retrieve form data
    $nama = $_POST["nama"];
    $alamat = $_POST["alamat"];
    $notel = $_POST["notel"];
    $jk = $_POST["jk"];

    // Validate Nama 
    if (!preg_match("/^[a-zA-Z ]*$/", trim($nama))) {
        die("Hanya boleh huruf untuk nama");
    }

    // Validate No Telepon 
    if (!preg_match("/^[0-9]+$/", trim($notel))) {
        die("Hanya boleh angka no hp");
    }

    if($_POST["jk"] == 0){
      die("Jenis Kelamin Tidak Valid");
    }else if($_POST["jk"] == 1){
      $jk = "Laki-Laki";
    }else if($_POST["jk"] == 2){
      $jk = "Perempuan";
    }

    echo "<h2>Form Data:</h2>";
    echo "Nama: $nama<br>";
    echo "Alamat: $alamat<br>";
    echo "No Telepon: $notel<br>";
    echo "Jenis Kelamin: $jk<br>";
}
?>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form</title>
  </head>
  <body>
    <form method="post">
        <table>
          <tr>
            <td>Nama</td>
            <td>
              <input type="text" name="nama" id="nama" required><br/>
            </td>
          </tr>

          <tr>
            <td>Alamat</td>
            <td>
              <input type="text" name="alamat" id="alamat" required><br/>
            </td>
          </tr>

          <tr>
            <td>No Telepon</td>
            <td>
              <input type="tel" name="notel" id="notel" required><br/>
            </td>
          </tr>

          <tr>
            <td>Jenis Kelamin</td>
            <td>
            <select name="jk" id="jk" style="width: 100%;" required>

              <option value="0">Pilih Jenis Kelamin</option>
              <option value="1">Laki-Laki</option>
              <option value="2">Perempuan</option>
            </select>
            </td>
          </tr>

          <tr>
          <td></td>
            <td>
              <input type="submit" style="width: 100%; margin-top: 10px;" name="submit" value="Submit"/>
            </td>
          </tr>

        </table>
    </form>
  </body>

</html>