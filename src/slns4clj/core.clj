(ns slns4clj.core
  (use [clojure.test])
  (require [clojure.string]
    [clojure.set]))

; Problem 1
(with-test
  (def prb-1 true)
  (is (= prb-1 true)))

; Problem 2
(with-test
  (def prb-2 4)
  (is (= (- 10 (* 2 3)) prb-2)))

; Problem 3
(with-test
  (def prb-3 "HELLO WORLD")
  (is (= prb-3 (.toUpperCase "hello world"))))

; Problem 4
; __ = :a :b :c
(deftest prb-4
  (is (= (list :a :b :c) '(:a :b :c))))

; Problem 5
(with-test
  (def prb-5 '(1 2 3 4))
  (is (= prb-5 (conj '(2 3 4) 1)))
  (is (= prb-5 (conj '(3 4) 2 1))))

; Problem 6
; __ = :a :b :c
(deftest prb-6
  (is (= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))))

; Problem 7 
(with-test
  (def prb-7 [1 2 3 4])
  (is (= prb-7 (conj [1 2 3] 4)))
  (is (= prb-7 (conj [1 2] 3 4))))

; Problem 8
(with-test
  (def prb-8 #{:a :b :c :d})
  (is (= prb-8 (set '(:a :a :b :c :c :c :c :d :d))))
  (is (= prb-8 (clojure.set/union #{:a :b :c} #{:b :c :d}))))

; Problem 9
(with-test
  (def prb-9 2)
  (is (= #{1 2 3 4} (conj #{1 4 3} prb-9))))

; Problem 10
(with-test
  (def prb-10 20)
  (is (= prb-10 ((hash-map :a 10, :b 20, :c 30) :b)))
  (is (= prb-10 (:b {:a 10, :b 20, :c 30}))))

; Problem 11
(with-test
  (def prb-11 {:b 2})
  (is (= {:a 1, :b 2, :c 3} (conj {:a 1} prb-11 [:c 3]))))

; Problem 12
(with-test
  (def prb-12 3)
  (is (= prb-12 (first '(3 2 1))))
  (is (= prb-12 (second [2 3 4])))
  (is (= prb-12 (last (list 1 2 3)))))

; Problem 13
(with-test
  (def prb-13 [20 30 40])
  (is (= prb-13 (rest [10 20 30 40]))))

; Problem 14
(with-test
  (def prb-14 8)
  (is (= prb-14 ((fn add-five [x] (+ x 5)) 3)))
  (is (= prb-14 ((fn [x] (+ x 5)) 3)))
  (is (= prb-14 (#(+ % 5) 3)))
  (is (= prb-14 ((partial + 5) 3))))

; Problem 15
; __ = * 2
(deftest prb-15
  (is (= (* 2 2) 4))
  (is (= (* 2 3) 6))
  (is (= (* 2 11) 22))
  (is (= (* 2 7) 14)))

; Problem 16
(with-test
  (def prb-16 (fn [name] (str "Hello, " name "!")))
  (is (= (prb-16 "Dave") "Hello, Dave!"))
  (is (= (prb-16 "Jenn") "Hello, Jenn!"))
  (is (= (prb-16 "Rhea") "Hello, Rhea!")))

; Problem 17
(with-test
  (def prb-17 '(6 7 8))
  (is (= prb-17 (map #(+ % 5) '(1 2 3)))))

; Problem 18
(with-test
  (def prb-18 '(6 7))
  (is (= prb-18 (filter #(> % 5) '(3 4 5 6 7)))))

; Problem 19
(with-test
  (def prb-19 #(nth %1 (- (count %1) 1)))
  (is (= (is (prb-19 [1 2 3 4 5]) 5)))
  (is (= (is (prb-19 '(5 4 3)) 3)))
  (is (= (is (prb-19 ["b" "c" "d"]) "d"))))

; Problem 20
(with-test
  (def prb-20 #(let [size (count %1)]
                 (if (< size 2)
                   nil
                   (nth %1 (- size 2)))))
  (is (= (prb-20 (list 1 2 3 4 5)) 4))
  (is (= (prb-20 ["a" "b" "c"]) "b"))
  (is (= (prb-20 [[1 2] [3 4]]) [1 2])))

; Problem 21
(with-test
  (def prb-21 (fn
                [coll idx]
                (if (== 0 idx)
                  (first coll)
                  (recur (rest coll) (dec idx)))))
  (is (= (prb-21 '(4 5 6 7) 2) 6))
  (is (= (prb-21 [:a :b :c] 0) :a))
  (is (= (prb-21 [1 2 3 4] 1) 2))
  (is (= (prb-21 '([1 2] [3 4] [5 6]) 2) [5 6])))

; Problem 22
(with-test
  (def prb-22 (fn [coll] (reduce (fn [x y] (+ x 1)) 0 coll)))
  (is (= (prb-22 '(1 2 3 3 1)) 5))
  (is (= (prb-22 "Hello World") 11))
  (is (= (prb-22 [[1 2] [3 4] [5 6]]) 3))
  (is (= (prb-22 '(13)) 1))
  (is (= (prb-22 '(:a :b :c)) 3)))

; Problem 23
(with-test
  (def prb-23 #(reduce conj () %1))
  (is (= (prb-23 [1 2 3 4 5]) [5 4 3 2 1]))
  (is (= (prb-23 (sorted-set 5 7 2 7)) '(7 5 2)))
  (is (= (prb-23 [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])))


; Problem 24
(with-test
  (def prb-24 #(reduce + %1))
  (is (= (prb-24 [1 2 3]) 6))
  (is (= (prb-24 (list 0 -2 5 5)) 8))
  (is (= (prb-24 #{4 2 1}) 7))
  (is (= (prb-24 '(0 0 -1)) -1))
  (is (= (prb-24 '(1 10 3)) 14)))

; Problem 25
(with-test
  (def prb-25 (fn [coll] (filter #(odd? %1) coll)))
  (is (= (prb-25 #{1 2 3 4 5}) '(1 3 5)))
  (is (= (prb-25 [4 2 1 6]) '(1)))
  (is (= (prb-25 [2 2 4 6]) '()))
  (is (= (prb-25 [1 1 1 3]) '(1 1 1 3))))

; Problem 26
(with-test
  (def prb-26 (fn [size]
                (loop [iter (range 1 (+ 1 size)) n_1 1 n_2 1 result ()]
                  (if (seq iter)
                    (let [current (if (< (first iter) 3)
                                    1
                                    (+ n_1 n_2))]
                      (recur (rest iter) current n_1 (cons current result)))
                    (reverse result)))))
  (is (= (prb-26 3) '(1 1 2)))
  (is (= (prb-26 6) '(1 1 2 3 5 8)))
  (is (= (prb-26 8) '(1 1 2 3 5 8 13 21))))

; Problem 27
(with-test
  (def prb-27 (fn [coll]
                (if (> 2 (count coll))
                  true
                  (if (= (first coll) (last coll))
                    (recur (rest (butlast coll)))
                    false))))
  (is (false? (prb-27 '(1 2 3 4 5))))
  (is (true? (prb-27 "racecar")))
  (is (true? (prb-27 [:foo :bar :foo])))
  (is (true? (prb-27 '(1 1 3 3 1 1))))
  (is (false? (prb-27 '(:a :b :c)))))

; Problem 28
(with-test
  (def prb-28 (fn [coll] (filter #(not (sequential? %1))
                           (rest (tree-seq sequential? seq coll)))))
  (is (= (prb-28 '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)))
  (is (= (prb-28 ["a" ["b"] "c"]) '("a" "b" "c")))
  (is (= (prb-28 '((((:a))))) '(:a))))

; Problem 29
(with-test
  (def prb-29 (fn [coll] 
                (let [uppers (filter 
                               #(not (= (clojure.string/lower-case %1) (str %1))) 
                               coll)]
                  (condp = (count uppers)
                    0 nil
                    1 (str uppers)
                    (reduce #(str %1 %2) uppers)))))
  (is (= (prb-29 "HeLlO, WoRlD!") "HLOWRD"))
  (is (empty? (prb-29 "nothing")))
  (is (= (prb-29 "$#A(*&987Zf") "AZ")))

; Problem 30
(with-test
  (def prb-30 (fn [coll]
                (reverse (loop [coll coll result ()]
                           (if (seq coll)
                             (let [pair (take 2 coll)]
                               (if (= (first pair) (second pair))
                                 (recur (next coll) result)
                                 (recur (next coll) (conj result (first pair)))))
                             result)))))
  (is (= (apply str (prb-30 "Leeeeeerrroyyy")) "Leroy"))
  (is (= (prb-30 [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
  (is (= (prb-30 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))))

; Problem 31
(with-test
  (def prb-31 (fn
                [coll]
                (loop [coll (rest coll) prv (first coll) found 1 result ()]
                  (if (seq coll)
                    (if (= prv (first coll))
                      (recur (rest coll) prv (inc found) result)
                      (recur (rest coll) (first coll) 1 (concat result [(take found (repeat prv))])))
                    (concat result [(take found (repeat prv))])))))
  (is (= (prb-31 [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))
  (is (= (prb-31 [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
  (is (= (prb-31 [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))))

; Problem 32
(with-test
  (def prb-32 #(apply concat (for [x %1] (list x x))))
  (is (= (prb-32 [1 2 3]) '(1 1 2 2 3 3)))
  (is (= (prb-32 [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
  (is (= (prb-32 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))
  (is (= (prb-32 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))))

; Problem 33
(with-test
  (def prb-33 #(apply concat (for [x %1] (take %2 (repeat x)))))
  (is (= (prb-33 [1 2 3] 2) '(1 1 2 2 3 3)))
  (is (= (prb-33 [:a :b] 4) '(:a :a :a :a :b :b :b :b)))
  (is (= (prb-33 [4 5 6] 1) '(4 5 6)))
  (is (= (prb-33 [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])))
  (is (= (prb-33 [44 33] 2) [44 44 33 33])))

; Problem 34
(with-test
  (def prb-34 (fn [low high & result]
                (if (>= low high)
                  (reverse result)
                  (recur (inc low) high (conj result low)))))
  (is (= (prb-34 1 4) '(1 2 3)))
  (is (= (prb-34 -2 2) '(-2 -1 0 1)))
  (is (= (prb-34 5 8) '(5 6 7))))

; Problem 35
(with-test
  (def prb-35 7)
  (is (= prb-35 (let [x 5] (+ 2 x))))
  (is (= prb-35 (let [x 3, y 10] (- y x))))
  (is (= prb-35 (let [x 21] (let [y 3] (/ x y))))))

; Problem 36
; __ = [x 7 y 3 z 1]
(deftest prb-36
  (is (= 10 (let [x 7 y 3 z 1] (+ x y))))
  (is (= 4 (let [x 7 y 3 z 1] (+ y z))))
  (is (= 1 (let [x 7 y 3 z 1] z))))

; Problem 37
(with-test
  (def prb-37 "ABC")
  (is (= prb-37 (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))))

; Problem 38
(with-test
  (def prb-38 (fn
                [& args]
                (if (< 1 (count args))
                  (if (< (second args) (first args))
                    (recur (cons (first args) (nnext args)))
                    (recur (cons (second args) (nnext args))))
                  (first args))))
  (is (= (prb-38 1 8 3 4) 8))
  (is (= (prb-38 30 20) 30))
  (is (= (prb-38 45 67 11) 67)))

; Problem 39
(with-test
  (def prb-39 (fn 
                [xs ys]
                (loop [xs xs ys ys result ()]
                  (if (and (seq xs) (seq ys))
                    (recur (rest xs) 
                      (rest ys) 
                      (concat result (list (first xs) (first ys))))
                    result))))
  (is (= (prb-39 [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)))
  (is (= (prb-39 [1 2] [3 4 5 6]) '(1 3 2 4)))
  (is (= (prb-39 [1 2 3 4] [5]) [1 5]))
  (is (= (prb-39 [30 20] [25 15]) [30 25 20 15])))

; Problem 40
(with-test
  (def prb-40 (fn [item coll] (butlast (flatten (for [x coll] (list x item))))))
  (is (= (prb-40 0 [1 2 3]) [1 0 2 0 3]))
  (is (= (apply str (prb-40 ", " ["one" "two" "three"])) "one, two, three"))
  (is (= (prb-40 :z [:a :b :c :d]) [:a :z :b :z :c :z :d])))

; Problem 41
(with-test
  (def prb-41 (fn
                [coll idx]
                (loop [coll coll iter idx result ()]
                  (if (seq coll)
                    (if (= iter 1)
                      (recur (rest coll) idx result)
                      (recur (rest coll) (dec iter) (cons (first coll) result)))
                    (reverse result)))))
  (is (= (prb-41 [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
  (is (= (prb-41 [:a :b :c :d :e :f] 2) [:a :c :e]))
  (is (= (prb-41 [1 2 3 4 5 6] 4) [1 2 3 5 6])))

; Problem 42
(with-test
  (def prb-42 (fn
                [size & result]
                (if (> size 0)
                  (recur (dec size) (* size (if (nil? result) 1 result)))
                  result)))
  (is (= (prb-42 1) 1))
  (is (= (prb-42 3) 6))
  (is (= (prb-42 5) 120))
  (is (= (prb-42 8) 40320)))

; Problem 43
(with-test
  (def prb-43 (fn 
                [coll splits & results]
                (let [size (/ (count coll) splits)]
                  (for [rng (range splits)]
                    (for [each (range size)]
                      (nth coll (+ (* each splits) rng)))))))
  (is (= (prb-43 [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))))
  (is (= (prb-43 (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))))
  (is (= (prb-43 (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))))

; Problem 44
(with-test
  (def prb-44
    (fn [shift coll]
      (let [shift (rem shift (count coll))]
        (if (pos? shift)
          (concat (drop shift coll) (take shift coll))
          (let [diff (- (count coll) (* -1 shift))]
            (concat (drop diff coll) (take diff coll)))))))
  (is (= (prb-44 2 [1 2 3 4 5]) '(3 4 5 1 2)))
  (is (= (prb-44 -2 [1 2 3 4 5]) '(4 5 1 2 3)))
  (is (= (prb-44 6 [1 2 3 4 5]) '(2 3 4 5 1)))
  (is (= (prb-44 1 '(:a :b :c)) '(:b :c :a)))
  (is (= (prb-44 -4 '(:a :b :c)) '(:c :a :b))))

; Problem 45
(with-test
  (def prb-45 '(1 4 7 10 13))
  (is (= prb-45 (take 5 (iterate #(+ 3 %) 1)))))

; Problem 46
(with-test
  (def prb-46
    (fn [op]
      (fn [x y]
        (op y x))))
  (is (= 3 ((prb-46 nth) 2 [1 2 3 4 5])))
  (is (= true ((prb-46 >) 7 8)))
  (is (= 4 ((prb-46 quot) 2 8)))
  (is (= [1 2 3] ((prb-46 take) [1 2 3 4 5] 3))))

; Problem 47
(with-test
  (def prb-47 4)
  (is (contains? #{4 5 6} prb-47))
  (is (contains? [1 1 1 1 1] prb-47))
  (is (contains? {4 :a 2 :b} prb-47))
  (is (not (contains? '(1 2 4) prb-47))))

; Problem 48
(with-test
  (def prb-48 6)
  (is (= prb-48 (some #{2 7 6} [5 6 7 8])))
  (is (= prb-48 (some #(when (even? %) %) [5 6 7 8]))))

; Problem 49
(with-test
  (def prb-49
    (fn [loc coll]
      (conj () (loop [coll coll loc loc]
                 (if (< 0 loc)
                   (recur (rest coll) (dec loc))
                   coll)) 
            (take loc coll))))
  (is (= (prb-49 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]))
  (is (= (prb-49 1 [:a :b :c :d]) [[:a] [:b :c :d]]))
  (is (= (prb-49 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])))

; Problem 50
(with-test
  (def prb-50
    (fn [coll]
      (loop [coll coll result {}] 
        (if (seq coll)
          (let [xtype (type (first coll))]
            (recur (rest coll) (assoc result xtype (conj (if (result xtype)
                                                           (result xtype)
                                                           []) (first coll)))))
          (vals result)))))
  (is (= (set (prb-50 [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}))
  (is (= (set (prb-50 [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]}))
  (is (= (set (prb-50 [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})))

; Problem 51
(with-test
  (def prb-51 [1 2 3 4 5])
  (is (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] prb-51] [a b c d]))))

; Problem 52
(with-test
  (def prb-52 [2 4])
  (is (= [2 4] (let [[a b c d e f g] (range)] prb-52))))

; Problem 53
(with-test
  (def prb-53
    (fn [coll]
      (loop [coll coll curr [] longest []]
        (if (seq coll)
          (if (empty? longest)
            (recur (next coll) [(first coll)] [(first coll)])
            (if (> (first coll) (if (last curr) (last curr) -1))
              (let [curr (conj curr (first coll))]
                (recur (next coll) curr (if (> (count curr) (count longest)) curr longest)))
              (recur (next coll) [(first coll)] longest)))
          (if (>= (count longest) 2)
            longest
            [])))))
  (is (= (prb-53 [1 0 1 2 3 0 4 5]) [0 1 2 3]))
  (is (= (prb-53 [5 6 1 3 2 7]) [5 6]))
  (is (= (prb-53 [2 3 3 4 5]) [3 4 5]))
  (is (= (prb-53 [7 6 5 4]) [])))

; Problem 54
(with-test
  (def prb-54
    (fn [cnt coll]
      (loop [coll coll result ()]
        (if (>= (count coll) cnt)
          (recur (drop cnt coll) (conj result (take cnt coll)))
          (reverse result)))))
  (is (= (prb-54 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))
  (is (= (prb-54 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))
  (is (= (prb-54 3 (range 8)) '((0 1 2) (3 4 5)))))

; Problem 55
(with-test
  (def prb-55
    (fn [coll]
      (loop [coll coll result {}]
        (if (seq coll)
          (let [k (first coll)]
            (recur 
              (next coll) 
              (assoc result k (inc (if (result k) (result k) 0)))))
          result))))
  (is (= (prb-55 [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))
  (is (= (prb-55 [:b :a :b :a :b]) {:a 2, :b 3}))
  (is (= (prb-55 '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})))
  
; Problem 56
(with-test
  (def prb-56
    (fn [coll]
      (loop [coll coll result []]
        (if (seq coll)
          (recur (rest coll) (if (some #(= % (first coll)) result)
                               result
                               (conj result (first coll))))
          result))))
  (is (= (prb-56 [1 2 1 3 1 2 4]) [1 2 3 4]))
  (is (= (prb-56 [:a :a :b :b :c :c]) [:a :b :c]))
  (is (= (prb-56 '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3])))
  (is (= (prb-56 (range 50)) (range 50))))

; Problem 57
(with-test
  (def prb-57 '(5 4 3 2 1))
  (is (= prb-57 ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))))

; Problem 58
(with-test
  (def prb-58
    (fn [& ops]
      (fn [& data]
        (loop [ops (reverse ops) data data]
          (if (seq ops)
            (recur (rest ops) (apply (juxt (first ops)) data))
            (first data))))))
  (is (= [3 2 1] ((prb-58 rest reverse) [1 2 3 4])))
  (is (= 5 ((prb-58 (partial + 3) second) [1 2 3 4])))
  (is (= true ((prb-58 zero? #(mod % 8) +) 3 5 7 9)))
  (is (= "HELLO" ((prb-58 #(.toUpperCase %) #(apply str %) take) 5 "hello world"))))

; Problem 59
(with-test
  (def prb-59
    (fn [& ops]
      (fn [& data]
        (for [op ops]
          (if (seq data)
            (apply op data)
            (op data))))))
  (is (= [21 6 1] ((prb-59 + max min) 2 3 5 1 6 4)))
  (is (= ["HELLO" 5] ((prb-59 #(.toUpperCase %) count) "hello")))
  (is (= [2 6 4] ((prb-59 :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))))
  

; Problem 61
(with-test
  (def prb-61 
    (fn [ks vs]
      (let [cnt (if (< (count ks) (count vs))
                  (count ks)
                  (count vs))]
        (into {} (for [x (range cnt)]
                   [(nth ks x) (nth vs x)])))))
  (is (= (prb-61 [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3}))
  (is (= (prb-61 [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"}))
  (is (= (prb-61 [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})))
    
; Problem 62
(with-test
  (def prb-62
    (fn my-iterate [func init]
      (lazy-seq (cons init (my-iterate func (func init))))))
  (is (= (take 5 (prb-62 #(* 2 %) 1)) [1 2 4 8 16]))
  (is (= (take 100 (prb-62 inc 0)) (take 100 (range))))
  (is (= (take 9 (prb-62 #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))))

; Problem 66
(with-test
  (def prb-66 
    (fn [a b]
      (if (== b 0)
        a
        (recur b, (mod a b)))))
  (is (= (prb-66 2 4) 2))
  (is (= (prb-66 10 5) 5))
  (is (= (prb-66 5 7) 1))
  (is (= (prb-66 1023 858) 33)))

; Problem 70
(with-test
  (def prb-70
    (fn [sentence]
      (let [words (clojure.string/split sentence #"[ .,!]")]
        (sort #(compare (.toLowerCase %1) 
                        (.toLowerCase %2)) words))))
  (is (= (prb-70  "Have a nice day.")
   ["a" "day" "Have" "nice"]))
  (is (= (prb-70  "Clojure is a fun language!")
   ["a" "Clojure" "fun" "is" "language"]))
  (is (= (prb-70  "Fools fall for foolish follies.")
   ["fall" "follies" "foolish" "Fools" "for"])))
  
; Problem 81
(with-test
  (def prb-81
    (fn [a b]
      (set (filter a b))))
  (is (= (prb-81 #{0 1 2 3} #{2 3 4 5}) #{2 3}))
  (is (= (prb-81 #{0 1 2} #{3 4 5}) #{}))
  (is (= (prb-81 #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})))
  
; Problem 83
(with-test
  (def prb-83
    (fn [& bools]
      (= true (and (some #(= % true) bools) (some #(= % false) bools)))))
  (is (= false (prb-83 false false)))
  (is (= true (prb-83 true false)))
  (is (= false (prb-83 true)))
  (is (= true (prb-83 false true false)))
  (is (= false (prb-83 true true true)))
  (is (= true (prb-83 true true true false))))
  
; Problem 90
(with-test
  (def prb-90
    (fn [a b]
      (set 
      (apply concat (for [ax a]
        (for [bx b]
          [ax bx]))))))
  (is (= (prb-90 #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
         #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
           ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
           ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}))
  (is (= (prb-90 #{1 2 3} #{4 5})
         #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}))
  (is (= 300 (count (prb-90 (into #{} (range 10))
                            (into #{} (range 30)))))))

; Problem 99
(with-test
  (def prb-99
    (fn [a b]
      (let [prod (* a b)]
        (loop [prod prod result '()]
          (if (> prod 0)
            (recur (int (/ prod 10)) (conj result (mod prod 10)))
            result)))))
  (is (= (prb-99 1 1) [1]))
  (is (= (prb-99 99 9) [8 9 1]))
  (is (= (prb-99 999 99) [9 8 9 0 1])))

; Problem 100
;(with-test
;  (def prb-100
;    (fn [& args]
;      ()))
;  (is (== (prb-100 2 3) 6))
;  (is (== (prb-100 5 3 7) 105))
;  (is (== (prb-100 1/3 2/5) 2))
;  (is (== (prb-100 3/4 1/6) 3/2))
;  (is (== (prb-100 7 5/7 2 3/5) 210)))


; Problem 107
(with-test
  (def prb-107
    (fn [x]
      (fn [y]
        (loop [acc 1 result 1]
          (if (<= acc x)
            (recur (inc acc) (* result y))
            result)))))
  (is (= 256 ((prb-107 2) 16),
       ((prb-107 8) 2)))
  (is (= [1 8 27 64] (map (prb-107 3) [1 2 3 4])))
  (is (= [1 2 4 8 16] (map #((prb-107 %) 2) [0 1 2 3 4]))))


; Problem 135
(with-test
  (def prb-135 
    (fn [& args]
      (if (>= (count args) 3)
        (let [[l op r & xs] args]
          (recur (conj xs (op l r) )))
        (first args))))
  (is (= 7  (prb-135 2 + 5)))
  (is (= 42 (prb-135 38 + 48 - 2 / 2)))
  (is (= 8  (prb-135 10 / 2 - 1 * 2)))
  (is (= 72 (prb-135 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))))

; Problem 146
(with-test
  (def prb-146 
    (fn
      [input-map]
      (into {} (for [x input-map kv (second x)]
                 [[(key x) (key kv)] (val kv)]))))
  (is (= (prb-146 '{a {p 1, q 2}
                    b {m 3, n 4}})
        '{[a p] 1, [a q] 2
          [b m] 3, [b n] 4}))
  (is (= (prb-146 '{[1] {a b c d}
                    [2] {q r s t u v w x}})
        '{[[1] a] b, [[1] c] d,
          [[2] q] r, [[2] s] t,
          [[2] u] v, [[2] w] x}))
  (is (= (prb-146 '{m {1 [a b c] 3 nil}})
        '{[m 1] [a b c], [m 3] nil}) ))

; Problem 147
(with-test
  (def prb-147
    (fn [xs]
      (let [row-builder #(loop [xs % result [(first xs)]]
                           (if (< (count xs) 2)
                             (conj result (last xs))
                             (recur (rest xs) (conj result (+ (bigint (first xs)) (bigint (second xs)))))))]
        (iterate row-builder xs))))
  (is (= (second (prb-147 [2 3 2])) [2 5 5 2]))
  (is (= (take 5 (prb-147 [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]]))
  (is (= (take 2 (prb-147 [3 1 2])) [[3 1 2] [3 4 3 2]]))
  (is (= (take 100 (prb-147 [2 4 2])) (rest (take 101 (prb-147 [2 2]))))))

; Problem 148
; Need to optimize, too slow to pass tests...
;(with-test
;  (def prb-148
;    (fn [biggie a b]
;      (apply + (filter #(or (== 0 (rem % a)) (== 0 (rem % b))) (range 2 biggie)))))
;  (is (= 0 (prb-148 3 17 11)))
;  (is (= 23 (prb-148 10 3 5)))
;  (is (= 233168 (prb-148 1000 3 5)))
;  (is (= "2333333316666668" (str (prb-148 100000000 3 5))))
;  (is (= "110389610389889610389610"
;      (str (prb-148 (* 10000 10000 10000) 7 11))))
;  (is (= "1277732511922987429116"
;      (str (prb-148 (* 10000 10000 10000) 757 809))))
;  (is (= "4530161696788274281"
;      (str (prb-148 (* 10000 10000 1000) 1597 3571)))))

; Problem 150
(with-test
  (def prb-150 
    (fn [n]
      (let [is-palindrom? (fn [x] 
                            (let
                              [strx (str x)
                               size (int (/ (count strx) 2))
                               lft (take size strx)
                               rht (take size (reverse strx))]
                              (= lft rht)))
            sub-generator (fn [x]
                            (if (sequential? x)
                              (let [[half is-odd?] x
                                    rollover? (apply = (conj half \9))
                                    half (seq (str (inc (bigint (apply str half)))))]
                                (if rollover?
                                  (if is-odd?
                                    [(drop-last half) (not is-odd?)]
                                    [half (not is-odd?)])
                                  [half is-odd?]))
                              (let [seqx (str x) ; Number as a sequence
                                    size (count seqx) ; Number of digits in number
                                    half (take (/ size 2) seqx)] ; First half of the number
                                (if (is-palindrom? x)
                                  [(take (/ size 2) seqx) (odd? size)]
                                  (if (> (bigint (apply str half)) ; First half is larger than second half
                                        (bigint (apply str (take (/ size 2) (reverse seqx)))))
                                    [half (odd? size)]
                                    [(seq (str (inc (bigint (apply str half))))) (odd? size)])))))]
        (map #(let [[half is-odd?] %1]
                (bigint (apply str (concat half 
                                     (if is-odd?
                                       (rest (reverse half))
                                       (reverse half))))))
          (next (iterate sub-generator n))))))
  (is (= (take 26 (prb-150 0))
        [0 1 2 3 4 5 6 7 8 9
         11 22 33 44 55 66 77 88 99
         101 111 121 131 141 151 161]))
  (is (= (take 16 (prb-150 162))
        [171 181 191 202
         212 222 232 242
         252 262 272 282
         292 303 313 323]))
  (is (= (take 6 (prb-150 1234550000))
        [1234554321 1234664321 1234774321
         1234884321 1234994321 1235005321]))
  (is (= (first (prb-150 (* 111111111 111111111)))
        (* 111111111 111111111)))
  (is (= (set (take 199 (prb-150 0)))
        (set (map #(first (prb-150 %)) (range 0 10000)))))
  (is (= true
        (apply < (take 6666 (prb-150 9999999)))))
  (is (= (nth (prb-150 0) 10101)
        9102019)))

