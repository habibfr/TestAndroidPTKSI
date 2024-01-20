
SELECT tm.NamaMahasiswa, tmk.NamaMataKuliah, tn.Grade
FROM tmahasiswa tm
JOIN tnilai tn ON tm.NIRM = tn.NIRM
JOIN tmatakuliah tmk ON tn.kodeMK = tmk.KodeMK
WHERE DATEDIFF(CURDATE(), tm.TglLahir) > 25
  AND tn.Grade < 60;


-- Output
-- NamaMahasiswa	NamaMataKuliah	Grade	
-- Erens	Matematika	40