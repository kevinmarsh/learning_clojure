(ns algorithms.quick-sort)

(defn quick-sort [col]
  (if (> 2 (count col)) col
      (let [pivot (first col)
            to-sort (rest col)
            less (filter (partial >= pivot) to-sort)
            greater (filter (partial < pivot) to-sort)]
        (concat (quick-sort less) [pivot] (quick-sort greater)))))

