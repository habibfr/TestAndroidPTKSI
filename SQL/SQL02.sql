SELECT tmk.KodeMK, tmk.NamaMataKuliah, tmk.Pengajar
FROM tmatakuliah tmk
LEFT JOIN tnilai tn ON tmk.KodeMK = tn.kodeMK
WHERE tn.kodeMK IS NULL;

-- Output
-- KodeMK	NamaMataKuliah	Pengajar	
-- MK-07	Pancasila	Linda