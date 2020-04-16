//
//  ViewController.swift
//  uilmageView
//
//  Created by estgames on 2017. 12. 11..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        let rect = CGRect(x: 0, y: 0, width: 300, height: 200)
        let imageView = UIImageView(frame: rect)
        
        //imageView.contentMode = .scaleAspectFit //이미지의 가로세로 비율을 유지한 채로 이미지 뷰에 들어가도록 맞춘다.
        imageView.contentMode = .center //이미지를 축소하지 않고 표현, 가운데 부분만 잘려서 표시
        imageView.clipsToBounds = true  //이미지가 이미지 뷰 넘어서 표시되지 않게
        
        imageView.image = UIImage(named: "sheep")
        //이미지 뷰의 좌표를 루트뷰 중앙으로 이동
        imageView.center = self.view.center
        self.view.addSubview(imageView)
        
        let image = UIImage(named: "stars")
        
        self.view.backgroundColor = UIColor.init(patternImage: image!)  //패턴이미지 사용법 변경됨..
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

