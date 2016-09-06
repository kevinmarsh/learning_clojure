(ns fourclojure.fibonacci
    (:require [clojure.set]))

;; http://www.4clojure.com/problem/26
;; My first attempt was pretty terrible, not optimized at all:

(defn first-attempt-fibonacci [x]
  (map (fn dumbfib [n]
    (if (<= n 1)
        n
        (+ (dumbfib (- n 1)) (dumbfib (- n 2))))) (range 1 (inc x))))

;; Here's a slightly better (but not great) version

(defn fibonacci [n]
  (loop [x 1
         y 1
         counter n]
    (if (= counter 0)
        y
        (recur (+ x y) x (dec counter)))))

(defn start-fibonacci [n]
  (map #(fibonacci %) (range n)))

;; Turned into a one liner for 4clojure

(fn [x]
  (let [fibonacci (fn [n]
    (loop [x 1
           y 1
           counter n]
      (if (= counter 0)
          y
          (recur (+ x y) x (dec counter)))))]
  (map #(fibonacci %) (range x))))
