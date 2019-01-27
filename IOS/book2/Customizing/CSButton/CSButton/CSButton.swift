//
//  CSButton.swift
//  CSButton
//
//  Created by estgames on 2017. 12. 21..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

public enum CSButtonType {
    case rect
    case circle
}

class CSButton: UIButton {
    var style: CSButtonType = .rect {
        didSet {
            switch style {
                case .rect :
                    self.backgroundColor = UIColor.black
                    self.layer.borderColor = UIColor.black.cgColor
                    self.layer.borderWidth = 2
                    self.layer.cornerRadius = 0
                    self.setTitleColor(UIColor.white, for: .normal)
                    self.setTitle("Rect Button", for: .normal)
                case .circle :
                    self.backgroundColor = UIColor.red
                    self.layer.borderColor = UIColor.blue.cgColor
                    self.layer.borderWidth = 2
                    self.layer.cornerRadius = 50
                    self.setTitle("Circle Button", for: .normal)
            }
        }
    }

    required init?(coder aDecoder: NSCoder) {   //스토리보드 방식으로 객체를 생성할 때 호출되는 메소드
        super.init(coder: aDecoder)
        
        self.backgroundColor = UIColor.green
        self.layer.borderWidth = 2
        self.layer.borderColor = UIColor.black.cgColor
        self.setTitle("버튼", for: .normal)
    }
    
    override init(frame: CGRect) {  //소스코드로 구현할 때 초기화 메소드
        super.init(frame: frame)
        
        self.backgroundColor = UIColor.gray
        self.layer.borderColor = UIColor.black.cgColor
        self.layer.borderWidth = 2
        self.setTitle("코드로 생성된 버튼", for: .normal)
    }
    
    init() {
        super.init(frame:CGRect.zero)
    }
    
    convenience init(type: CSButtonType) {
        self.init()
        
        switch type {
            case .rect :
                self.backgroundColor = UIColor.black
                self.layer.borderColor = UIColor.black.cgColor
                self.layer.borderWidth = 2
                self.layer.cornerRadius = 0
                self.setTitleColor(UIColor.white, for: .normal)
                self.setTitle("Rect Button", for: .normal)
            case .circle :
                self.backgroundColor = UIColor.red
                self.layer.borderColor = UIColor.blue.cgColor
                self.layer.borderWidth = 2
                self.layer.cornerRadius = 50
                self.setTitle("Circle Button", for: .normal)
        }
        
        self.addTarget(self, action: #selector(counting(_:)), for: .touchUpInside)
    }
    
    @objc func counting(_ sender: UIButton) {
        sender.tag = sender.tag + 1
        sender.setTitle("\(sender.tag) 번째 클릭", for: .normal)
    }
    
    /*
    // Only override draw() if you perform custom drawing.
    // An empty implementation adversely affects performance during animation.
    override func draw(_ rect: CGRect) {
        // Drawing code
    }
    */

}
