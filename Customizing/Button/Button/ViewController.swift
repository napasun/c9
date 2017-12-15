//
//  ViewController.swift
//  Button
//
//  Created by estgames on 2017. 12. 15..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @objc func btnOnClick(_ sender: Any) {  //Any, AnyObject, UIButton으로 매개변수 설정 가능
        if let btn = sender as? UIButton {
            btn.setTitle("클릭", for: UIControlState.normal)
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        let btn = UIButton(type: UIButtonType.system)       //버튼 생성
        btn.frame = CGRect(x: 50, y: 100, width: 150, height: 30)   //위치와 크기
        btn.setTitle("테스트 버튼", for: UIControlState.normal)
        
        btn.center = CGPoint(x: self.view.frame.size.width / 2, y: 100) //객체의 중심좌표 지정
        
        self.view.addSubview(btn)
        
        //버튼의 이벤트와 메소드 연결
        btn.addTarget(self, action: #selector(btnOnClick(_:)), for: .touchUpInside)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

