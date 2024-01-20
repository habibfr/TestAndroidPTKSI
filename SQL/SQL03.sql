SELECT tm.NamaMahasiswa
FROM tmahasiswa tm
JOIN tnilai tn ON tm.NIRM = tn.NIRM
JOIN tmatakuliah tmk ON tn.kodeMK = tmk.KodeMK
WHERE tmk.NamaMataKuliah IN ('Matematika', 'Aljabar');


-- Output
-- NamaMahasiswa	
-- Natasha
-- Erens
-- Natasha