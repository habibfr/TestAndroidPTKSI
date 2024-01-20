SELECT tmk.KodeMK, tmk.NamaMataKuliah, ROUND(AVG(tn.Grade), 2)  AS RataRataNilai
FROM tmatakuliah tmk
JOIN tnilai tn ON tmk.KodeMK = tn.kodeMK
GROUP BY tmk.KodeMK, tmk.NamaMataKuliah
HAVING AVG(tn.Grade) > 75;

-- Output
-- KodeMK	NamaMataKuliah	RataRataNilai	
-- MK-03	Statistika	80.00
-- MK-05	Aljabar	78.00