SELECT tmk.KodeMK, tmk.NamaMataKuliah, ROUND(AVG(tn.Grade), 2) AS RataRataNilai
FROM tmatakuliah tmk
JOIN tnilai tn ON tmk.KodeMK = tn.kodeMK
GROUP BY tmk.KodeMK, tmk.NamaMataKuliah;

-- Output
-- KodeMK	NamaMataKuliah	RataRataNilai	
-- MK-01	Matematika	55.00
-- MK-03	Statistika	80.00
-- MK-05	Aljabar	78.00