# 원서 번역


## brew 설치

ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

npm install gitbook-cli -g

brew install Caskroom/cask/calibre

mkdir -p my-book/_draft && cd my-book

<!--SUMMARY.md-->

# Table of Contents

- [Chapter 1](_draft/chapter1.md)
- [Chapter 2](_draft/chapter2.md)


gitbook serve

# gitbook {format} {source_path} {output_path}

$ gitbook pdf ./ _build/my-book.pdf
$ gitbook epub ./ _build/my-book.epub
$ gitbook mobi ./ _build/my-book.mobi




<span style="color: red">