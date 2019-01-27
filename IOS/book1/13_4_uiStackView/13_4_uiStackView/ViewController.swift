//
//  ViewController.swift
//  13_4_uiStackView
//
//  Created by estgames on 2017. 12. 11..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        let view1 = UIView()
        view1.backgroundColor = .lightGray
        let view2 = UIView()
        view2.backgroundColor = .gray
        
        let photo1 = UIImageView(image: UIImage(named : "IMG_4048"))
        let photo2 = UIImageView(image: UIImage(named : "IMG_4202"))
        let photo3 = UIImageView(image: UIImage(named : "IMG_4854"))
        photo1.contentMode = .scaleAspectFit
        photo1.clipsToBounds = true
        photo2.contentMode = .scaleAspectFit
        photo2.clipsToBounds = true
        photo3.contentMode = .scaleAspectFit
        photo3.clipsToBounds = true
        
        //스택뷰를 만듬
        let rect = CGRect(x: 0, y: 0, width: 300, height: 600)
        let stackView = UIStackView(frame:rect)
        stackView.axis = .vertical  //세로
        stackView.distribution = .fillEqually
        stackView.spacing = 10
        
        //스택뷰에 뷰를 추가
        stackView.addArrangedSubview(view1)
        stackView.addArrangedSubview(view2)
        stackView.addArrangedSubview(photo1)
        stackView.addArrangedSubview(photo2)
        stackView.addArrangedSubview(photo3)
        
        //스택뷰를 화면 중앙에 표시
        stackView.center = self.view.center
        self.view.addSubview(stackView)
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

