(ns ex_1_3)

; using min, map and reduce

(defn f [x y z]
  (let [smallest-number (min x y z)
        two-largest-numbers (cond (= smallest-number x)[y z]
                                  (= smallest-number y)[x z]
                                  :else [x y])]
  (reduce + 0 (map #(* % %) two-largest-numbers))))

; without using min, map and reduce

(defn smallest [x y z]
  (cond (and (< x y) (< x z)) x
        (and (< y x) (< y z)) y
        :else z))

(defn sum-of-squares [x y]
  (+ (* x x) (* y y)))

(defn f2 [x y z]
  (let [smallest-number (smallest x y z)]
    (cond (= smallest-number x)(sum-of-squares y z)
          (= smallest-number y)(sum-of-squares x z)
          :else (sum-of-squares x y))))

; Dean Wampler's solution

(defn f3 [a b c]
  (if (> a b) 
    (+ (* a a) (if (> b c) (* b b) (* c c)))
    (+ (* b b) (if (> a c) (* a a) (* c c)))))

