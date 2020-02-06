;; implementation from 
;;https://clojure.github.io/clojure/clojure.string-api.html
(require ['clojure.string :as 'str])

;; Merge list implementation from  github douglas-vaz/merge
;;https://gist.github.com/douglas-vaz/0ad52921918bad5fa2fd
(defn merge-list [X Y]
  (loop [ [xhead & xtail :as x] X, [yhead & ytail :as y] Y, Result []]
    (if (and (not-empty x) (not-empty y))
      (if (<= xhead yhead)
        (recur xtail y (conj Result xhead))
        (recur x ytail (conj Result yhead)))
      (concat Result x y))))

;; merge sort implementation (merge sort kata in Clojure) 
;;http://www.dirv.me/merge-sort-kata/

;; reference of map https://clojuredocs.org/clojure.core/map
;; reference of apply 
;;https://clojuredocs.org/clojure.core/apply
;; reference of pmap 
;;https://clojuredocs.org/clojure.core/pmap
(defn merge-sort [input]
  (if (<  (count input) 2 ) input 
    (apply merge-list 
      (map merge-sort 
        (split-at (/ (count input) 2) input)))))

(defn merge-sort-thread-2 [input]
  (if (<  (count input) 2 ) input 
    (apply merge-list 
      (pmap merge-sort 
        (split-at (/ (count input) 2) input)))))

(defn merge-sort-thread-4 [input]
  (if (<  (count input) 2 ) input 
    (apply merge-list 
      (pmap merge-sort-thread-2 
        (split-at (/ (count input) 2) input)))))

(defn merge-sort-thread-8 [input]
  (if (<  (count input) 2 ) input 
    (apply merge-list 
      (pmap merge-sort-thread-4 
        (split-at (/ (count input) 2) input)))))

(defn merge-sort-thread-16 [input]
  (if (<  (count input) 2 ) input 
    (apply merge-list 
      (pmap  merge-sort-thread-8
        (split-at (/ (count input) 2) input)))))

(defn merge-sort-thread-32 [input]
  (if (<  (count input) 2 ) input 
    (apply merge-list 
      (pmap merge-sort-thread-16 
        (split-at (/ (count input) 2) input)))))


;;File reader implementation from file reader implementation https://stackoverflow.com/questions/55770730/trying-to-read-a-text-file-in-clojure-and-insert-the-data-into-a-list-or-a-vecto

;; reference for time https://clojuredocs.org/clojure.core/time
(defn file-reader[fname]
 (let [file-contents (slurp fname) 
  nums-as-strings   (str/split file-contents #" ")  
  numbers           (map read-string nums-as-strings)]
  (time(merge-sort numbers ))
  (time(merge-sort-thread-2 numbers))
  (time(merge-sort-thread-4 numbers))
  (time(merge-sort-thread-8 numbers))
  (time(merge-sort-thread-16 numbers))
  (time(merge-sort-thread-32 numbers))
  ))

(file-reader "10000.txt")