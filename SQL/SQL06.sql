SELECT tmk.KodeMK, tmk.NamaMataKuliah, COUNT(tn.NIRM) AS JumlahMahasiswa
FROM tmatakuliah tmk
JOIN tnilai tn ON tmk.KodeMK = tn.kodeMK
GROUP BY tmk.KodeMK, tmk.NamaMataKuliah
ORDER BY JumlahMahasiswa DESC
LIMIT 1;


-- Output
-- KodeMK	NamaMataKuliah	JumlahMahasiswa	
-- MK-01	Matematika	2